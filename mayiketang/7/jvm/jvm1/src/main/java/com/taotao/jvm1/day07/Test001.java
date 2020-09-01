package com.taotao.jvm1.day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *@author tom
 *Date  2020/8/17 0017 8:34
 *memoryAnalyzer
 */
public class Test001 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> mayikts = new ArrayList<>();
        mayikts.add("mk");
        mayikts.add("mt");
        System.out.println("存储成功..");
        System.in.read();
        mayikts=null;
        System.out.println("mk变为空");
        System.in.read();
        System.in.read();
        System.out.println("end");
    }
}
