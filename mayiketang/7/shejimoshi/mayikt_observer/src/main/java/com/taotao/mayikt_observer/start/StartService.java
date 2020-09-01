package com.taotao.mayikt_observer.start;

import com.taotao.mayikt_observer.observer.MayiktSubject;
import com.taotao.mayikt_observer.observer.Observer;
import com.taotao.mayikt_observer.observer.impl.EmailObserver;
import com.taotao.mayikt_observer.observer.impl.SMSObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.applet.AppletContext;
import java.util.Map;

/**
 *@author tom
 *Date  2020/5/26 0026 23:57
 *
 */
@Component
public class StartService  implements ApplicationRunner {
    @Autowired
    private SMSObserver smsObserver;
    @Autowired
    private EmailObserver emailObserver;
    @Autowired
    private MayiktSubject mayiktSubject;
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public void run(ApplicationArguments args) throws Exception {
          //  mayiktSubject.addobserver(smsObserver);
          //  mayiktSubject.addobserver(emailObserver);
            //使用java反射机制获取observer子类
        /**
         * 自动注册我们的观察者
         * 1，使用spring获取该obServer 下有哪些bean对象
         * 2，直接添加到集合中
         */
        Map<String, Observer> map=applicationContext.getBeansOfType(Observer.class);
        for (String key:map.keySet()
             ) {
            Observer observer=map.get(key);
            mayiktSubject.addobserver(observer);
        }
    }

}
