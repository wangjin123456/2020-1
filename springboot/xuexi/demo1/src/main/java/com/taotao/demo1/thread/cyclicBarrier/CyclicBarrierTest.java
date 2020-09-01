package com.taotao.demo1.thread.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author tom
 * @date 2020/4/4 0004 10:03
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {

        //第一步定义玩家
        String [] heros={"武则天","孙悟空","猪八戒","貂蝉","甄姬"};
        //第二步， 使用线程池来运行，也是5个
        ExecutorService service = Executors.newFixedThreadPool(5);
        //第三步，常见围栏，也是5个
        int threadNum=5;
        final CyclicBarrier barrier=new CyclicBarrier(threadNum);
        //第四步。通过循环传递给每一个玩家和围栏
        for (int i = 0; i <threadNum ; i++) {
            service.execute(new Player(heros[i],barrier));
        }
        service.shutdown();
    }

    private static class Player implements Runnable {
        private final  String hero;
        private  final CyclicBarrier barrier;
        public Player(String hero, CyclicBarrier barrier) {
            this.hero=hero;
            this.barrier=barrier;
        }

        @Override
        public void run() {
          try {
              //每个英雄加载成功的时间不一样，所以这里用随机数
              TimeUnit.SECONDS.sleep(new Random().nextInt(5));
              System.out.println(hero+"： 开始加载==========等待其他玩家加载成功");
              barrier.await();
              System.out.println(hero+": 看到所有玩家加载成功，比赛开始");
          }catch (Exception e){
              e.getCause();
          }
        }
    }
}
