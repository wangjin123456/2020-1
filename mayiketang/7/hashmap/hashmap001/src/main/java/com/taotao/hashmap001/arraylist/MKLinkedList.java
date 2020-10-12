package com.taotao.hashmap001.arraylist;

/**
 *@author tom
 *Date  2020/10/12 0012 6:54
 *
 */
public class MKLinkedList<E> {

    public static void main(String[] args) {
        MKLinkedList mkLinkedList = new MKLinkedList();
        for (int i = 0; i < 10; i++) {
            mkLinkedList.add("mk" + i);
        }
        mkLinkedList.remove(1);
        for (int i = 0; i < 10; i++) {
            System.out.println(mkLinkedList.get(i));
        }
    }

    //记录当前链表头节点
    transient Node<E> first;
    //记录当前链表尾节点
    transient Node<E> last;

    transient int size = 0;

    public void add(E e) {
        //获取当前的尾节点
        Node<E> l = last;
        //采用尾插法
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            //第一次新增node节点
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    //删除
    public  boolean remove(int index){
        Node<E> delnode=get1(index);

        if(delnode==null){
            return  false;
        }
        Node<E> prev=delnode.prev;
        Node<E> next=delnode.next;
        //判断删除的节点是否为头节点
         if(prev==null){
             first=next;
         }else {
            prev.next=next;
         }
         if(next==null){
             last=prev;
         }else {
             next.prev=prev;
             delnode.next=null;
         }
         size--;
         return  true;
    }
    public E get(int index) {
        return getNode(index).item;
    }
    public Node<E> get1(int index) {
        return getNode(index);
    }

    public Node<E> getNode(int index) {

        if (index < size / 2) {
                Node x = first;//折半
                for (int j = 0; j <index; j++) {
                    x = x.next;
                }
                return  x;

        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;

            }
            return x;
        }

    }

    private static class Node<E> {
        //元素
        E item;
        Node<E> next;
        //上个节点
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
