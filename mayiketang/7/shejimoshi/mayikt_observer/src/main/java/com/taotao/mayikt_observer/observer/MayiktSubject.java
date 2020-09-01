package com.taotao.mayikt_observer.observer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author tom
 *Date  2020/5/26 0026 23:44
 *
 */
@Component
public class MayiktSubject {
    private ExecutorService executorService;
    //可定长度线程池
    public  MayiktSubject(){
        executorService= Executors.newFixedThreadPool(10);
    }
    /**
     * 类型
     */
    private List<Observer> listObserver =new ArrayList<>();

    /**
     * 新增   listObserver
     * @param observer
     */
    public void addobserver(Observer observer){
        listObserver.add(observer);
    }

    /**
     * 通知给所有的观察者
     * @param jsonObject
     */
    public  void notifyObserver(JSONObject jsonObject){
        for (Observer oberserver:listObserver  ) {
            //单独开启线程异步通知
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    oberserver.sendMsg(jsonObject);
                }
            });


        }
    }
}
