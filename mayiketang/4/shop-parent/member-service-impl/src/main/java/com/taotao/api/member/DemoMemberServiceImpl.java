package com.taotao.api.member;

import com.taotao.base.BaseApiService;
import com.taotao.base.ResponseBase;
import com.taotao.member.IDemoMemberService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/5/5 0005 7:57
 *
 */

@RestController
@Api(description = "会员服务接口")
public class DemoMemberServiceImpl extends BaseApiService implements IDemoMemberService {

    @Override
    @ApiOperation("根据用户userId查询会员信息")
    @ApiResponse(code = 200, message = "查询结果成功")
    @ApiImplicitParam(name = "userId", value = "用户userId")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "获取数据成功"), @ApiResponse(code = 400, message = "参数错误"), })
    @GetMapping("/demoMember")
    public ResponseBase demoMember(@RequestParam("userId") Long userId) {
        return setResultSuccess("会员服务,微服务电商项目基本环境搭建成功...");
    }

}
