package com.taotao.demo1.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author tom
 * @date 2020/4/9 0009 14:48
 */
public class RateLimitterMain {


    public static void main(String[] args) {
        RateLimiter rateLimiter =RateLimiter.create(100);
        for (int i = 0; i <10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
             rateLimiter.acquire();
                    System.out.println("pass");
                }
            }).start();
        }
    }
}
