package com.taotao.lamba;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *@author tom
 *Date  2020/6/4 0004 9:58
 *
 */
public class Test09 {
    public static void main(String[] args) {
        List<UserEntity> list=new ArrayList<>();
        list.add(new UserEntity("mayikt", 22));
        list.add(new UserEntity("meite", 183));
        list.add(new UserEntity("zhangsan", 35));
        list.forEach(a->
                System.out.println(a.getAge()));

        list.forEach(new Consumer<UserEntity>() {
            @Override
            public void accept(UserEntity userEntity) {
                System.out.println(userEntity.getAge());
            }
        });
        new Thread(() -> System.out.println("我是子线程")).start();
    }

}
