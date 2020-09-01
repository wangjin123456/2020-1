package com.taotao.member.controller;


import com.taotao.member.entity.MeiteUser;
import com.taotao.member.service.IMeiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-06-09
 */
@RestController
@RequestMapping("")
public class MeiteUserController {
@Autowired
    private IMeiteUserService iMeiteUserService;

  @GetMapping("/findByUser")
  public MeiteUser findByUser(Integer userId){
      return  iMeiteUserService.findByUser(userId);
  }
}
