package com.itmayiedu.api.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itmayiedu.api.member.IMemberService;
import com.itmayiedu.api.service.IOrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/5/2 0002 21:41
 *
 */
@RestController
public class OrderController implements IOrderService {
    @Reference
    private IMemberService imemberService;
    /*
    *订单服务调用会员服务
     */
    @GetMapping("/orderToMember")
    @Override
    public String orderToMember(String name) {
        return imemberService.getUser();
    }

    @RequestMapping("/index")
    public  String index(){
        return  imemberService.getUser();
    }
    @RequestMapping("/index1")
    public  String index1(){
        return  "22";
    }
}
