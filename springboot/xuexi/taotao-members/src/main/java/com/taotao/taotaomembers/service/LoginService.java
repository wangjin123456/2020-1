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
 * Date  2020/4/15 0015 15:36
 */
@RestController
@Api("用户登录接口")
@CrossOrigin//解决跨域
public class LoginService  extends BaseApiService<JSONObject> {
@Autowired
    private UserMapper userMapper;

    /**
     * 登录接口
     * @param userEntity
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登陆接口", notes = "用户登陆")
    @ApiImplicitParams({@ApiImplicitParam(name = "mobile", value = "手机号码", required = true,
            dataType = "String"), @ApiImplicitParam(name = "password", value = "用户密码", required = true,
            dataType = "String")})
    public BaseResponse<JSONObject> login(UserEntity userEntity) {
        return userMapper.login(userEntity.getMobile(), userEntity.getPassword()) !=
                null ? setResultSuccess("登陆成功") : setResultError("登陆失败");
    }

}
