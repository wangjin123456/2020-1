package com.taotao.jvm1.day04;

import java.util.HashMap;

/**
 *@author tom
 *Date  2020/8/13 0013 9:41
 *内存泄露问题
 * -Xmx3M -Xms3M
 */
public class HashMapMemoryLeak {

    public static void main(String[] args) {
        HashMap<HashKey2, Integer> map = new HashMap<HashKey2, Integer>(1000);
        int counter = 0;

        while (true) {
            //循环插入新对象new出很多很多内存地址不等的对象
            HashKey2 p = new HashKey2("mk", "22");
            map.put(p, 1);
            counter++;
            if (counter % 1000 == 0) {
                System.out.println("map size:" + map.size());
                System.out.println("运行：" + counter + "次后，可用内存剩余" + Runtime.getRuntime().freeMemory() / (1024 * 1024) + "MB");


            }
        }
    }

    static class HashKey2 {
        private final String id;
        private String name;

        public HashKey2(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        /**
         * hashMap 不管怎么new 多少次 只会key 只会引入一次 不会继续添加。
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof HashKey2)
                return name.equals(((HashKey2) obj).name) && id.equals(((HashKey2) obj).id);
            else
                return false;
        }
    }
}
