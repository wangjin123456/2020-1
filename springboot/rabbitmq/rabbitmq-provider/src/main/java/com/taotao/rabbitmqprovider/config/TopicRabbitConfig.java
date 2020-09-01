package com.taotao.rabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;


/**
 * 主题交换机
 * @autor tom
 * @date 2020/3/19 0019 16:25
 */
@Configuration
public class TopicRabbitConfig {
    //绑定建
    public  final static String man="topic.man";
    public final static  String woman="topic.woman";
    @Bean
    public Queue firstQueue(){
        return  new Queue(TopicRabbitConfig.man);
    }

    @Bean
    public  Queue secondQueue(){
        return  new Queue(TopicRabbitConfig.woman);
    }

    @Bean
    TopicExchange exchange(){
        return  new TopicExchange("topicExchange");
    }
    /**
     * 将firstQueue 和 topicExchange绑定，而且绑定的键值为 topic.man
     *z这样只要是消息携带的路由键是topic.man，才会分发到该队列
     */
    @Bean
    Binding bindingExchangeMessage(){
        return  BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }
    /**
     * 将SecondQueue 和 topicExchange绑定，而且绑定的键值为 topic.#
     *z这样只要是消息携带的路由键是topic.#，才会分发到该队列
     */
    @Bean
    Binding bindingExchangeMessage2(){
        return  BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }
}
