package com.taotao.zuoye.thread;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author tom
 *Date  2020/7/15 0015 7:48
 *
 */
public class Thread003 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建子线程");
            }
        });

    }
}
