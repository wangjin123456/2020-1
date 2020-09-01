package com.taotao.metithread;

/**
 *@author tom
 *Date  2020/7/20 0020 7:36
 *synchronized 重入锁
 */
public class Test005  extends  Thread{
    private Object lookobject=new Object();

    @Override
    public void run() {
        a();
    }

    private  void a() {
        synchronized (lookobject){
            System.out.println("我是a调用b");
            b();
        }
    }

    private void b() {
        synchronized (lookobject){
            System.out.println("我是b");
        }
    }

    public static void main(String[] args) {
        new Test005().start();
    }
}
