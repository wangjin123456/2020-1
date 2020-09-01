package com.taotao.rabbitproducer.famout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 *@author tom
 *Date  2020/5/13 0013 13:08
 *
 */
@Component
public class FamoutConfig {

    /**
     * 定义死信队列相关信息
     */
    public final static String deadQueueName = "dead_queue";
    public final static String deadRoutingKey = "dead_routing_key";
    public final static String deadExchangeName = "dead_exchange";
    /**
     * 死信队列 交换机标识符
     */
    public static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
    /**
     * 死信队列交换机绑定键标识符
     */
    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    //1 创建消费队列名称
    // 邮件队列
    private String FANOUT_EMAIL_QUEUE = "new_fanout_eamil_queue";

    // 短信队列
    private String FANOUT_SMS_QUEUE = "new_fanout_sms_queue";
    // 交换机
    private String EXCHANGE_NAME = "new_fanoutExchange";

    //定义邮件队列
      @Bean
    public Queue famOutEmailQueue(){
        //  return new Queue(FANOUT_EMAIL_QUEUE);
          //邮件队列绑定死信队列
          Map<String,Object> args=new HashMap<>(2);
          args.put(DEAD_LETTER_QUEUE_KEY, deadExchangeName);
          args.put(DEAD_LETTER_ROUTING_KEY, deadRoutingKey);
          Queue queue =new Queue(FANOUT_EMAIL_QUEUE,true,false,false,args);
          return queue;

      }

    @Bean
    public Queue famOutSmsQueue(){
        return new Queue(FANOUT_SMS_QUEUE);
    }
    //定义交换机
    @Bean
    public FanoutExchange fanoutExchange(){
          return new  FanoutExchange(EXCHANGE_NAME);
    }
    //3定义队列
// 3.队列与交换机绑定邮件队列
    @Bean
    Binding bindingExchangeEamil(Queue famOutEmailQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(famOutEmailQueue).to(fanoutExchange);
    }

    // 4.队列与交换机绑定短信队列
    @Bean
    Binding bindingExchangeSms(Queue famOutSmsQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(famOutSmsQueue).to(fanoutExchange);
    }

    /**
     * 配置死信队列
     *
     * @return
     */
    //死信队列
    @Bean
    public Queue deadQueue() {
        Queue queue = new Queue(deadQueueName, true);
        return queue;
    }
   //死信交换机
    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange(deadExchangeName);
    }

    //死信队列与交换机进行绑定
         @Bean
    public Binding bindingDeadExchange(Queue deadQueue, DirectExchange deadExchange) {
        return BindingBuilder.bind(deadQueue).to(deadExchange).with(deadRoutingKey);
    }


}
