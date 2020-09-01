package com.taotao;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 *@author tom
 *Date  2020/6/13 0013 12:27
 *
 */
public class JwtTest001 {
    private static  final  String signkey="mayikt_signkey";



    public static void main(String[] args) {
        JwtBuilder jwtBuilder=Jwts.builder().claim("userImg","sss")
                                 .setIssuedAt(new Date())
                //设置签名值
             .signWith(SignatureAlgorithm.HS256,signkey);
        System.out.println(jwtBuilder.compact());
    }
}
