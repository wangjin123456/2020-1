package com.itmayidu.springbootswagger.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/4/29 0029 10:47
 *
 */
@Api(tags = "管理相关接口")
@RestController
@RequestMapping("/")
public class IndexController {
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四")}
    )
    @GetMapping("index")
    public  String index(String name){
        return  name;
    }

    @RequestMapping(method = RequestMethod.POST,value = "userById")
    @ApiOperation(value = "获取用户信息", notes = "通过用户ID获取用户信息")
    public Object findById(@ApiParam(value = "用户ID",required = true) int id){
        return id;
    }


}
