package com.taotao.hashmap001;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *@author tom
 *Date  2020/9/27 0027 7:19
 *concurrentHashmap底层原理
 */
public class MyConcurrentHashMap<K, V> {
    /**
     * segments
     */
    private Hashtable<K, V>[] segments;

    public MyConcurrentHashMap() {
        segments = new Hashtable[16];
    }

    public void put(K k, V v) {
        //第一次计算index， 计算key存放在那个hashtable
        int segmentIndex = k.hashCode() & (segments.length - 1);
        Hashtable<K, V> segment = segments[segmentIndex];
        if (segment == null) {
            segment = new Hashtable<>();
        }
        segment.put(k, v);
      segments[segmentIndex]=segment;
    }


    public V get(K k) {
        //第一次计算index， 计算key存放在那个hashtable
        int segmentIndex = k.hashCode() & (segments.length - 1);
        Hashtable<K, V> segment = segments[segmentIndex];
        if (segment != null) {
            return segment.get(k);
        }
        return null;

    }

    public static void main(String[] args) {
        MyConcurrentHashMap<String, String> myConcurrentHashMap = new MyConcurrentHashMap<>();
        ConcurrentHashMap map=new ConcurrentHashMap();

        for (int i = 0; i < 10; i++) {
            myConcurrentHashMap.put(i + "", i + "");
        }
        for (int i = 0; i < 10; i++) {
            myConcurrentHashMap.get(i + "");
            System.out.println(  myConcurrentHashMap.get(i + ""));
        }
    }
}
