package com.taotao.mybatis.controller;

import com.taotao.mybatis.entity.User;
import com.taotao.mybatis.plung.PageInfo;
import com.taotao.mybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-03 10:56:27
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @GetMapping("ByPage")
    public List<User> ByPage(){
        return  this.userService.ByPage();

    }
}