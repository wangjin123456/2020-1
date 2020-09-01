package com.taotao.threads;

/**
 *@author tom
 *Date  2020/6/23 0023 9:27
 *
 */
public class Thread004 extends Thread {
       private    boolean flag=true;
    @Override
    public void run() {
        while(flag){
            System.out.println("执行线程"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread004 thread004 = new Thread004();
        thread004.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        thread004.stopThrad();
        // 不建议使用stopt停止线程，因为他底层使用强制停止线程 如果线程代码没有执行完毕的情况下则强制停止
    }
    private void stopThrad() {
        this.flag = false;
    }
}
