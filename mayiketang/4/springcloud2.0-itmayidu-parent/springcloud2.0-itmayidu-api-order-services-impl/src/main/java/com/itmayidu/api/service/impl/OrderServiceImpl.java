package com.itmayidu.api.service.impl;


import api.service.IOrderService;
import com.itmayidu.api.entity.UserEntity;
import com.itmayidu.api.service.feign.MemberServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.taotao.BaseApiService;
import com.taotao.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *@author tom
 *Date  2020/4/21 0021 23:46
 *
 */
@Api("订单服务接口")
@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {
    //订单服务实现类继承服务端接口，减少重复代码
    @Autowired
    private MemberServiceFeign memberServiceFeign;
    private static    int i=1;
    @Override
    @RequestMapping("/orderToMember")
    public String orderToMember(@RequestParam(value = "name") String name) {
       UserEntity user= memberServiceFeign.getMember(name);
        System.out.println("orderToMember:" + "线程池名称:" + Thread.currentThread().getName());
       i++;
        System.out.println("*********88"+i);
       return user==null ? "没有找到用户信息": user.toString();
    }

    /*
    *没有解决服务雪崩效应
     */
    @RequestMapping("/orderToMemberUserInfo")
    @Override
    public ResponseBase orderToMemberUserInfo() throws InterruptedException {
        return memberServiceFeign.getUserInfo();
    }

    /**
     * 解决雪崩
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/orderToMember1")
    @Override
    public ResponseBase orderInfo() throws InterruptedException {
        return setResultSuccess();
    }

    @Override
    @RequestMapping("/")
    public String index() {
        return "我是订单服务项目";
    }

    /**
     * 解决服务雪崩效应
     * @return
     * @throws InterruptedException
     */
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix() throws InterruptedException {
        System.out.println("orderToMemberUserInfoHystrix:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }
    @RequestMapping("/orderToMemberUserInfoHystrix_demo1")
    public ResponseBase orderToMemberUserInfoHystrix_demo1() throws InterruptedException {
        System.out.println("orderToMemberUserInfoHystrix:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }
    public ResponseBase orderToMemberUserInfoHystrixFallback() {
        return setResultSuccess("返回一个友好的提示：服务降级,服务器忙，请稍后重试!");
    }
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四")}
    )
    @GetMapping("index")
    public  String index(String name){
        return  name;
    }
}
