package com.taotao.mayikt_cglib;

import com.taotao.mayikt_cglib.service.impl.MemberServiceImpl;

/**
 *@author tom
 *Date  2020/5/25 0025 10:23
 *
 */
public class FastClass {
    /**
     * 方法名称加参数类型组合
     * @param signature
     * @return
     */
    public static int getIndex(String signature){
        switch (signature.hashCode()){
            case  -1403673461:
                return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        String name="addMember(String)";
        System.out.println(name.hashCode());
   //     System.out.println(invoke(getIndex(name),new MemberServiceImpl(),new Object[]{"meite"});

    }

    /**
     *
     * @param i 索引值
     * @param obj 代理对象
     * @param objArr  参数
     * @return
     */

    public static Object invoke(int i,Object obj,Object[] objArr){
        MemberServiceImpl memberService= (MemberServiceImpl) obj;
        //走我们的代理对象
        switch (i){
            case 0:
               memberService.addMember(String.valueOf(objArr[0]));

        }
        return  null;
    }
}
