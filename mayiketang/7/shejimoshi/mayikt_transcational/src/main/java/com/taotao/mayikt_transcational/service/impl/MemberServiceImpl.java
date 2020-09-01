package com.taotao.mayikt_transcational.service.impl;


import com.taotao.mayikt_transcational.aop.MeiteTransaction;
import com.taotao.mayikt_transcational.entity.UserEntity;
import com.taotao.mayikt_transcational.mapper.UserMapper;
import com.taotao.mayikt_transcational.util.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MemberService
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
public class MemberServiceImpl {

    @Autowired
    public UserMapper userMapper;
     @Autowired
     private TransactionUtils transactionUtils;

   /*  @MeiteTransaction
    @GetMapping("/insertUser")
    public String insertUser(UserEntity userEntity) {
        TransactionStatus beign = null;
        try {
            beign = transactionUtils.begin();
            String result = userMapper.insertUser(userEntity) > 0 ? "success" : "fail";
            int j = 1 / userEntity.getUserId();
            transactionUtils.commit(beign);
            return result;
        } catch (Exception e) {
            e.getCause();
            //手动回滚当前事务
            if (beign != null) {
                transactionUtils.rollback(beign);

            }
            return "系统错误";
        }


    }*/

    @MeiteTransaction
    @GetMapping("/insertUser")
    public String insertUser(UserEntity userEntity) {

            String result = userMapper.insertUser(userEntity) > 0 ? "success" : "fail";
            int j = 1 / userEntity.getUserId();
              return result;



    }
}