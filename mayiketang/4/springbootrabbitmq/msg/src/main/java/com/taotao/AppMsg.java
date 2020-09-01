package com.taotao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *@author tom
 *Date  2020/5/14 0014 10:00
 *
 */
@RestController
@SpringBootApplication
public class AppMsg {
    public static void main(String[] args) {
        SpringApplication.run(AppMsg.class,args);
    }
    ///模拟第三方发送邮件
    @RequestMapping("/sendEmail")
    public Map<String, Object> sendEmail(String email) {
        System.out.println("开始发送邮件：" + email);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", "200");
        result.put("msg", "发送邮件成功");
        System.out.println("发送邮件成功");

        return result;

    }
}
