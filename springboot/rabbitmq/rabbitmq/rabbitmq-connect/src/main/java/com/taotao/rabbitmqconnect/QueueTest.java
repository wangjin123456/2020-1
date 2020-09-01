package com.taotao.rabbitmqconnect;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @autor tom
 * @date 2020/3/4 0004  21:57
 */
@Slf4j
public class QueueTest {
    public static void main(String[] args) {
      Queue queue= new LinkedList();
        queue.offer("tom");
        queue.offer("xiaowei");
        queue.offer("xiaomin");

        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }

}
