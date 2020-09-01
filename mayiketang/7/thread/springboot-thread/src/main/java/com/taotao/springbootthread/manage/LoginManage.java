package com.taotao.springbootthread.manage;

import com.taotao.springbootthread.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 *@author tom
 *Date  2020/6/23 0023 9:46
 *
 */
@Component
@Slf4j
public class LoginManage {
@Async
public Future<String> asynLogin(UserEntity userEntity) {
    loginlog(userEntity);
    sendMsg(userEntity);
    sendEmail(userEntity);
    return  new AsyncResult<String>("异步发送消息成功");
}

    private UserEntity sendEmail(UserEntity userEntity) {
        log.info(">>>4.正在发送邮件信息<<<");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        return new UserEntity();
    }

    private UserEntity sendMsg(UserEntity userEntity) {
        log.info(">>>3.正在发送短信信息<<<");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        return new UserEntity();
    }

    private UserEntity loginlog(UserEntity userEntity) {
        log.info(">>>2.正在异步记录登录日志<<<");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        return new UserEntity();
    }

    private UserEntity dbLogin(UserEntity userEntity){
        log.info(">>>>>>1,正在查询数据库");
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.getCause();
        }
        return  new UserEntity();
    }

}
