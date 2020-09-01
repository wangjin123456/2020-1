package com.itmayidu.springcloud2eurekamember.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tom
 * Date  2020/4/17 0017 10:27
 */
@RestController
public class MemberApiController {
  @Value("${server.port}")
  private String serverport;
    @RequestMapping("/getMember")
    public  String getMember(){
        return  "你最棒"+serverport;
    }

}
