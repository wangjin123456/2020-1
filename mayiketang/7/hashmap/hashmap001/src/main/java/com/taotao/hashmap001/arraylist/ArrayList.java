package com.taotao.hashmap001.arraylist;

import sun.management.snmp.jvminstr.JvmRTBootClassPathEntryImpl;

import java.util.Arrays;

/**
 *@author tom
 *Date  2020/10/7 0007 9:46
 *
 */

public class ArrayList<T> {

    //存放数据的元素
    private  Object[] elementData;

    //初始化个数
    private  int size=0;

    private  static  final  int DEFAULT_CAPACITY=10;

    public  ArrayList(){

    }

    /**
     * 新增元素
     */

    public  void add(T t){

        //默认初始化
        if(elementData==null){
            elementData=new Object[10];
        }
        //判断是否要做扩容
        if((size+1)>elementData.length){
                   //原来的容量
            int oldCapacity=elementData.length;
            //新容量10+10/2=15
            int newCapacity=oldCapacity+oldCapacity/2;
            elementData= Arrays.copyOf(elementData,newCapacity);
        }
        elementData[size++]=t;
        
    }
    public  T get(int index){
        return (T)elementData[index];
    }
//删除
    public boolean remove(T value){
        for (int i = 0; i <size ; i++) {
            T oldValue=(T)elementData[i];
            if(oldValue.equals(value)){
                int numMoved=size-i-1;
                if(numMoved>0){
                    System.arraycopy(elementData,i+1,elementData,i,numMoved);
                    elementData[--size]=null;
                    return  true;
                }
            }

        }
        return  false;
    }
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i = 0; i <23 ; i++) {
            arrayList.add("11"+i);
           // System.out.println(arrayList.get(i));
        }
        arrayList.remove("111");
        for (int i = 0; i <23 ; i++) {
          //  arrayList.add("11"+i);
            System.out.println(arrayList.get(i));
        }
    }

}
