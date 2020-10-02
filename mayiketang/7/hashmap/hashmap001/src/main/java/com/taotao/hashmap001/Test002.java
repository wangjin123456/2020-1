package com.taotao.hashmap001;

/**
 *@author tom
 *Date  2020/9/24 0024 18:13
 *
 */
public class Test002 {

    public static void main(String[] args) {
        Node<String,String> abode=new Node<String,String>();
        Node<String,String> cbode=new Node<String,String>();
        abode.next=cbode;
        cbode.next=abode;
        while (abode.next!=null){

        }
    }
    static class Node<K, V> {
        K k;
        V v;
        Node next;

    }

}
