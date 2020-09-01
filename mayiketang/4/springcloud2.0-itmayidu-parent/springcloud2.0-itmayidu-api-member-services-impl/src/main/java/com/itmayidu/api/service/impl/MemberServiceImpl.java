package com.itmayidu.api.service.impl;



import com.itmayidu.api.entity.UserEntity;
import com.itmayidu.api.service.IMemberService;
import com.taotao.BaseApiService;
import com.taotao.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/4/21 0021 20:23
 *
 */
@Api("会员服w务")
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {
    @Value("${server.port}")
    private String serverport;
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四")}
    )
    @GetMapping("index")
    public  String index(String name){
        return  name;
    }
    @Override
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam(value = "name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(21);
        return userEntity;
    }

    @Override
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() throws InterruptedException {
       //请求延迟
        System.out.println("订单服务调用会员服务");
        Thread.sleep(1500);
        return setResultSuccess("订单服务调用会员服务接口成功......"+ "端口号："+serverport);
    }
}
