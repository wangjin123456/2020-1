package com.taotao.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *@author tom
 *Date  2020/6/19 0019 9:43
 *
 */
public class Test0010 {
    public static void main(String[] args) {

      //stream流 数据来源于 数组和集合
        ArrayList<UserEntity> userEntities=new ArrayList<>();
        userEntities.add(new UserEntity("mayikt",20));
        userEntities.add(new UserEntity("e",250));
        userEntities.add(new UserEntity("a",15));
        userEntities.add(new UserEntity("g",200));
     //   userEntities.add(new UserEntity("g",200));

      /*  Stream<UserEntity>stream1=userEntities.stream();

        Stream<UserEntity> stream2=userEntities.parallelStream();


        userEntities.stream().limit(2).forEach(userEntity ->
                 System.out.println(userEntity.toString()));
*/

        //ArrayList转set
       /* Set<UserEntity> coolectSet=userEntities.stream().collect(Collectors.toSet());
        Set<UserEntity> coolectSet1=userEntities.stream().collect(Collectors.toSet());
        System.out.println(coolectSet);*/
        //ArrayList转map
       /* Function<UserEntity,String>  functionkey=new Function<UserEntity, String>() {
            @Override
            public String apply(UserEntity userEntity) {
                return userEntity.userName;
            }
        };
        Function<UserEntity,Integer>  functionvalue=new Function<UserEntity, Integer>() {
            @Override
            public Integer apply(UserEntity userEntity) {
                return userEntity.getAge();
            }
        };
        Map<String,Integer> collect=userEntities.stream().collect(Collectors.toMap(functionkey,functionvalue));
        System.out.println(collect.toString());
        Map<String,Integer> collect1= userEntities.stream().collect(Collectors.toMap(userkey1 -> userkey1.getUserName(),userValue -> userValue.getAge()));
        System.out.println(collect1.toString());
        Map<String,Integer> clooect2=userEntities.stream().collect(Collectors.toMap(UserEntity::getUserName,UserEntity::getAge));
        System.out.println(clooect2);*/
        //stream求和
        Stream<Integer> integerStream=Stream.of(10,20,30,40,40,20);
   /*   Optional<Integer> reduce= integerStream.reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a1, Integer a2) {
                return a1+a2;
            }
        });
        System.out.println(reduce);*/
/*          Optional<Integer>reduce1=  integerStream.reduce((a1,a2) -> a1+a2);
        System.out.println(reduce1.get());*/

    /*    Optional<UserEntity> reduce2=userEntities.stream().reduce(new BinaryOperator<UserEntity>() {
            @Override
            public UserEntity apply(UserEntity user1, UserEntity user2) {
                      user1.setAge(user1.getAge()+user2.getAge());
               return user1;
            }
        });
        System.out.println(reduce2.get());*/
        Optional<UserEntity> reduce3=userEntities.stream().reduce((user1,user2) ->{
           user1.setAge(user1.getAge()+user2.getAge());
           return  user1;
        });
        System.out.println(reduce3.get());
    }
}
