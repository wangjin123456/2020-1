package com.taotao.zuoye.thread;

/**
 *@author tom
 *Date  2020/7/17 0017 9:38
 *多线程之间的通讯
 * 多和线程多听一个对象实现，实现不同的操作，过程可以称作为多线程之间实现通讯
 */
public class Thread007 {
    class Res {
        public String userName;
        public char userSex;
        public boolean flag;
    }

    class InputThread extends Thread {
        private Res res;

        public InputThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            try {
                int count = 0;
                while (true) {
                    synchronized (res) {
                        if (this.res.flag) {
                            res.wait();
                        }
                        if (count == 0) {
                            this.res.userName = "22";
                            this.res.userSex = '女';
                        } else {
                            this.res.userName = "33";
                            this.res.userSex = '男';
                        }
                        System.out.println(res.userName + "," + res.userSex);
                        this.res.flag = true;
                        this.res.notify();

                    }
                    count = (count + 1) % 2;
                }


            } catch (Exception e) {
                e.getCause();
            }
        }


    }

    class OutThread extends Thread {

        private Res res;

        public OutThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (res) {
                        if (!res.flag) {
                            res.wait();
                        }
                        System.out.println(res.userName + "," + res.userSex);
                        res.flag = false;
                        res.notify();
                    }
                } catch (Exception e) {

                }

            }
        }
    }


    private void start() {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutThread outThread = new OutThread(res);
        inputThread.start();
        outThread.start();
    }

    public static void main(String[] args) {
        new Thread007().start();
    }
}
