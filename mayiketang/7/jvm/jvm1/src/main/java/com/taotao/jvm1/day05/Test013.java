package com.taotao.jvm1.day05;

import java.util.ArrayList;
import java.util.List;

/**
 *@author tom
 *Date  2020/8/15 0015 7:47
 *
 */
public class Test013 {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        for (int i = 0; i <30000000 ; i++) {
            System.out.println(i);
            list.add(String.valueOf(i));
        }
    }
}
