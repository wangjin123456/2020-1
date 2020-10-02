package com.taotao.hashmap001;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *@author tom
 *Date  2020/9/21 0021 19:48
 *缓存淘汰策略  访问顺序  get/put操作后其对应的键值会移动到末尾
 */
public class LruCache<K,V>extends LinkedHashMap<K,V> {
    /**
     * 容量
     */
    private int  capacity;

    public LruCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }
    /**
     * 如果超过存储容量则清除第一个
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
       return  size()>capacity;
    }

    public static void main(String[] args) {
        LruCache<String,String> lruCache=new LruCache<>(3);
 lruCache.put("a","a");
 lruCache.put("b","b");
 lruCache.put("c","c");
 lruCache.put("d","d");
 lruCache.forEach((k,v)->{
     System.out.println("k= "+k);
 });

    }
}
