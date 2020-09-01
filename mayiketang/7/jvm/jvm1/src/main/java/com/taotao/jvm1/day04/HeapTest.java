package com.taotao.jvm1.day04;

import java.util.ArrayList;

/**
 *@author tom
 *Date  2020/8/13 0013 9:36
 *-Xmx8m
 */
public class HeapTest {
    public static void main(String[] args) {
        int i=0;
        try {
            ArrayList<String> strings=new ArrayList<>();
            while (true){
                strings.add("mk");
                i++;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
