package com.taotao.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.taotao.service.HelloService;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/13 0013 22:27
 *
 */
@Service
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) throws Exception {
        Thread.sleep(2000);
        return  "hello"+name;
    }
}
