package com.taotao.dxfl.controller;

import com.taotao.dxfl.entity.MeiteUser;
import com.taotao.dxfl.mapper.MeiteUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@author tom
 *Date  2020/8/22 0022 10:28
 *
 */
@RestController
public class MtController {
    @Autowired
    private MeiteUserMapper meiteUserMapper;


    @RequestMapping("/find")
    public MeiteUser find(Integer userId){
        MeiteUser meiteUser = meiteUserMapper.select(userId);
        return meiteUser;
    }

    @GetMapping("/insertUser")
    public String insertUser(MeiteUser user) {
     meiteUserMapper.add(user);
        return "2";
    }
}
