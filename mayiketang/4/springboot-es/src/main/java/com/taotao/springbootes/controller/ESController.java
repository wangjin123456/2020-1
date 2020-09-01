package com.taotao.springbootes.controller;

import com.taotao.springbootes.dao.UserDao;
import com.taotao.springbootes.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 *@author tom
 *Date  2020/5/23 0023 9:41
 *
 */
@RestController
public class ESController {
    @Autowired
    private UserDao userDao;

    /**
     *
     * 添加文档
     * @param userEntity
     * @return
     */
    @RequestMapping("/addUser")
    public  UserEntity addUser( UserEntity userEntity){
       return userDao.save(userEntity);
    }

    /**
     * 查询文档
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Optional<UserEntity> findById(String id){
        return  userDao.findById(id);
    }
}
