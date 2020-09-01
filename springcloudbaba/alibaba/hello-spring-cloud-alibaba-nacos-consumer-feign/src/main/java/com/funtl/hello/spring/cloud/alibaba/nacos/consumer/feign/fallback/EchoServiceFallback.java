package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.fallback;

import com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(@PathVariable("message") String message) {
        return "echo fallback";
    }
}
