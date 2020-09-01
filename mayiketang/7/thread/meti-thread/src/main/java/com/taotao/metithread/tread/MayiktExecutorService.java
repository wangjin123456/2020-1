package com.taotao.metithread.tread;

import java.util.ArrayList;
import java.util.List;

/**
 *@author tom
 *Date  2020/6/7 0007 21:34
 *
 */
public class MayiktExecutorService {
    private List<Thread> workIngThread;

    public MayiktExecutorService(int corePoolSize,int maximumPoolSize) {
        workIngThread=new ArrayList<>();
        for (int i = 0; i < corePoolSize; i++) {
            
        }
    }

    class  TaskThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
