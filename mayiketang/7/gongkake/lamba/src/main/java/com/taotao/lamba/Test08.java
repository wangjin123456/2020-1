package com.taotao.lamba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *@author tom
 *Date  2020/6/4 0004 9:46
 *集合排序
 */
public class Test08 {
    public static void main(String[] args) {
        List<UserEntity> list=new ArrayList<UserEntity>();
        list.add(new UserEntity("mayikt",22));
        list.add(new UserEntity("meite",222));
        list.add(new UserEntity("zhangsan",2));
          list.sort( (a,b) ->a.getAge() -b.getAge());
          list.sort(new Comparator<UserEntity>() {
              @Override
              public int compare(UserEntity o1, UserEntity o2) {
                  return o1.getAge() -o2.getAge();
              }
          });
        System.out.println(list.toString());
    }
}
