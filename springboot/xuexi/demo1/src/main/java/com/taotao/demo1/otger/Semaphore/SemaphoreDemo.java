package com.taotao.demo1.otger.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 信号量机制
 * @author tom
 * @date 2020/4/4 0004 15:19
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo=new SemaphoreDemo();
                int N=9;//客人数量
        Semaphore semaphore=new Semaphore(5);//手牌数量，限制手牌数量
        for (int i = 0; i <N ; i++) {
            String vipNo="vip-00"+i;
            new Thread(() ->{
                try {
                    semaphore.acquire();//获取令牌

               semaphoreDemo.service(vipNo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放令牌
                }
            }).start();
        }



    }
    //限流，控制5个线程 同时访问
    private void service(String vipNo) throws InterruptedException {
        System.out.println("楼上出来迎接贵宾，贵宾编号" + vipNo+",,,,,");
           Thread.sleep(new Random().nextInt(30000));
        System.out.println("欢迎贵宾出门，贵宾编号"+vipNo);
    }


}
