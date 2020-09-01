package com.taotao.metithread.tread;

/**
 *@author tom
 *Date  2020/6/25 0025 9:01
 *
 */
public class TicketThread  implements Runnable{
    private  int count=20;
    @Override
    public  synchronized  void run() {
        while(count>0){
            try {
                Thread.sleep(300);
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName()+"正在出票第"+(20-count+1)+"张票");
            count--;
        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread=new TicketThread();
        new Thread(ticketThread,"窗口1").start();
        new Thread(ticketThread,"窗口2").start();
    }
}
