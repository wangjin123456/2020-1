package com.taotao.zuoye.guangchazhe.service.config;

import com.alibaba.fastjson.JSONObject;
import com.taotao.zuoye.guangchazhe.service.MayiktObserver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author tom
 *Date  2020/7/11 0011 9:02
 *
 */
@Component
public class MsyiktSubject {
    private ExecutorService executorService;
    private List<MayiktObserver> list = new ArrayList<MayiktObserver>();

    public MsyiktSubject() {
        executorService = Executors.newFixedThreadPool(10);

    }

    public void addServer(MayiktObserver mayiktObserver) {
        list.add(mayiktObserver);

    }

    public void deleteObserver(MayiktObserver observer) {
        list.remove(observer);
    }


    public void notifyObserver(final JSONObject jsonObject) {
        for (final MayiktObserver observer : list
        ) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    observer.sendMsg(jsonObject);
                }
            });
        }
    }

}
