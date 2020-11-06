package com.taotao.shardingjdbc.controller;

import com.taotao.shardingjdbc.entity.MayiktUser;
import com.taotao.shardingjdbc.mapper.MayiktUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@author tom
 *Date  2020/11/6 0006 8:41
 *
 */
@RestController
public class UserController {
    @Autowired
    private MayiktUserMapper mayiktUserMapper;


    @RequestMapping("/insertUser")
    public  String insertUser(){
        for (int i = 1; i <10 ; i++) {
            MayiktUser mayiktUser=new MayiktUser(i,"mykt"+i,i);
           try {
                mayiktUserMapper.insert(mayiktUser);
           }catch (Exception e){
               e.printStackTrace();
           }
        }
             return  "success";
    }

/**
 * 查询所有
 */

@RequestMapping("/userList")
public List<MayiktUser> userList(){
    return  mayiktUserMapper.userList();
}

/**
 * 分页查询
 */
@RequestMapping("/userListPage")
public  List<MayiktUser> userListpage(){
    return  mayiktUserMapper.userListPage();
}
/**
 * 排序
 */

@RequestMapping("/userOrderBy")
    public  List<MayiktUser> userOrderBy(){
    return  mayiktUserMapper.userOrderBy();
}

@RequestMapping("/getByUserId")
    public  List<MayiktUser> getByUserId(Long id){
    return  mayiktUserMapper.getByUserId(id);
}
}



