package com.taotao.taotaomembers.service;

import com.alibaba.fastjson.JSONObject;
import com.taotao.taotaomembers.base.BaseApiService;
import com.taotao.taotaomembers.base.BaseResponse;
import com.taotao.taotaomembers.entity.UserEntity;
import com.taotao.taotaomembers.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tom
 * Date  2020/4/15 0015 15:48
 */
@RestController
@Api("用户注册接口")
@CrossOrigin
public class RegisterService extends BaseApiService<JSONObject> {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/register")
    @ApiOperation(value = "注册接口", notes = "注册接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "mobile", value = "手机号码", required = true,
            dataType = "String"), @ApiImplicitParam(name = "password", value = "用户密码", required = true,
            dataType = "String")})
    public BaseResponse<JSONObject> register(UserEntity userEntity){
        try {
            int register=userMapper.register(userEntity);
            return register >0?setResultSuccess("注册成功"): setResultError("注册失败");
        }catch (Exception e){
            e.printStackTrace();
            return  setResultError("注册失败");
        }

    }





}
