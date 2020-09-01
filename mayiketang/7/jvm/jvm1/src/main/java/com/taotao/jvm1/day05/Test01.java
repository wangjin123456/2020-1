package com.taotao.jvm1.day05;

/**
 *@author tom
 *Date  2020/8/14 0014 8:23
 *
 */
public class Test01 {
    /**
     * 二进制文件存放那些信息： 类的信息，局部变量表，方法信息，常量池
     * @param args
     */
    public static void main(String[] args) {
      //  System.out.println("mk");
        String a1="a";
        String a2="a";
        String b="b";
        String ab1=a1+b;
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(a1);
        stringBuilder.append(b);
        stringBuilder.toString();
        String ab3="a"+"b";
        String ab="ab";
        System.out.println(ab1==ab);
        System.out.println(a1==a2);
        System.out.println(ab3==ab);
        //equals 比较内容值是否相等


        String c1="c";//字符串常量池
        String c2=new String("c");//new 对象字符串放入对内存空间中
       String c3= c2.intern();//将字符串对象字符放入到字符串常量池中
        System.out.println(c1==c2);
        System.out.println(c1==c3);
    }
}
