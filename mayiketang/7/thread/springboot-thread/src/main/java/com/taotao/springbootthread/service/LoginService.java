package com.taotao.springbootthread.service;

import com.taotao.springbootthread.entity.UserEntity;
import com.taotao.springbootthread.manage.LoginManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *@author tom
 *Date  2020/6/24 0024 7:44
 *
 */
@RestController
@Slf4j
public class LoginService {
    @Autowired
    private LoginManage loginManage;

    @GetMapping("/login")
    public ResponseEntity<String> login(UserEntity userEntity) throws ExecutionException, InterruptedException {
        //查询数据库
        UserEntity dbUser=dbLogin(userEntity);
        if(dbUser==null){
            return  ResponseEntity.status(500).body("账号不存在");
        }
        Future<String> StringFuture=loginManage.asynLogin(userEntity);
       return  ResponseEntity.status(200).body(StringFuture.get());
    }

    //com.mayikt.manage
    @Async
    public void asynLogin(UserEntity userEntity) {
        loginLog(userEntity);
        sendSms(userEntity);
        sendEmail(userEntity);
    }

    private UserEntity dbLogin(UserEntity userEntity) {
        log.info(">>>>1. 正在查询数据库");
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.getCause();
        }
        return  new UserEntity();
    }

    private void loginLog(UserEntity userEntity) {
        log.info(">>>2.异步开始写登陆的日志<<<");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
//        int i = 1 / 0;
    }

    private void sendSms(UserEntity userEntity) {
        log.info(">>>3.异步开始发送短信<<<");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }

    private void sendEmail(UserEntity userEntity) {
        log.info(">>>4.异步开始发送邮件<<<");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
}
