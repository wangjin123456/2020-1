package com.taotao.mayikt_lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *@author tom
 *Date  2020/6/15 0015 22:06
 *
 */
public class LruCahce<k,V>extends LinkedHashMap<k,V> {
    /**
     * 容量
     */
    private  int capacity;
    public  LruCahce(int capacity){
        super(16,0.75f,true);
        this.capacity=capacity;
    }

    /**
     * 如果长度 > capacity 则会清除第一个key
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<k, V> eldest) {
        if(size()>capacity){
            System.out.println("超出HashMap 已经定的大小");
        }
        return  size()>capacity;

    }

    public static void main(String[] args) {
        LruCahce<String,String> lruCahce=new LruCahce<String,String>(3);
        lruCahce.put("a","meite");
        lruCahce.put("b","meite");
        lruCahce.put("c","meite");
             lruCahce.get("a");

        lruCahce.put("e","meite");
        lruCahce.forEach((k,v)->{
            System.out.println(k+","+v);
        });
    }
}
