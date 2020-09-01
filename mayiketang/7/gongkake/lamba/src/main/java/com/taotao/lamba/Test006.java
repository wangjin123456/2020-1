package com.taotao.lamba;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *@author tom
 *Date  2020/6/9 0009 8:06
 *
 */
public class Test006 {
    public static void main(String[] args) {
        ArrayList<UserEntity> userEntityArrayList=new ArrayList<>();
        userEntityArrayList.add(new UserEntity("mayi",22));
        userEntityArrayList.add(new UserEntity("mayi1",222));
        userEntityArrayList.add(new UserEntity("mayi2",2));

        userEntityArrayList.sort((o1, o2) ->{
            return o1.getAge() -o2.getAge();
        } );
        userEntityArrayList.sort((o1, o2) ->
            o1.getAge() -o2.getAge()
        );
            userEntityArrayList.sort(new Comparator<UserEntity>() {
                @Override
                public int compare(UserEntity o1, UserEntity o2) {
                    return o1.getAge()-o2.getAge();
                }
            });
        System.out.println(userEntityArrayList.toString());

    }
}
