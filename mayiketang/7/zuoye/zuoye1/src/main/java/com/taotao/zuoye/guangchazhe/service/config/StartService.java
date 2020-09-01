package com.taotao.zuoye.guangchazhe.service.config;

import com.taotao.zuoye.guangchazhe.service.impl.EmailServer;
import com.taotao.zuoye.guangchazhe.service.impl.SmsObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/7/11 0011 9:11
 *
 */
@Component
public class StartService implements ApplicationRunner {
    @Autowired
    private MsyiktSubject msyiktSubject;
    @Autowired
    private EmailServer emailServer;
    @Autowired
    private SmsObserver smsObserver;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        msyiktSubject.addServer(emailServer);
        msyiktSubject.addServer(smsObserver);
    }
}
