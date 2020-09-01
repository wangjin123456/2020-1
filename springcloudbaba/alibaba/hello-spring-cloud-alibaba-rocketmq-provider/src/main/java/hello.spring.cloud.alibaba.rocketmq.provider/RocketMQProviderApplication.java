package hello.spring.cloud.alibaba.rocketmq.provider;

import hello.spring.cloud.alibaba.rocketmq.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author Administrator
 * @autor tom
 * @date 2020/3/23 0023 10:05
 */
@EnableBinding({Source.class})
@SpringBootApplication
public class RocketMQProviderApplication implements CommandLineRunner {
    @Autowired
    private ProviderService providerService;

    public static void main(String[] args) {
        SpringApplication.run(RocketMQProviderApplication.class,args);
    }

    /***
     *实现了 CommandLineRunner 接口，只是为了 Spring boot 启动时候执行任务
     * @param args
     * @throws Exception
     */
  @Override
    public void run(String... args) throws Exception {
            providerService.send("hello RocketMQ");
    }
}
