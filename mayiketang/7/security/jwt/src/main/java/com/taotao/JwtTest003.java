package com.taotao;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 *@author tom
 *Date  2020/6/13 0013 18:08
 *jwt过期时间
 */
public class JwtTest003 {
    private static  final  String signkey="mayikt_signkey";

    public static void main(String[] args) {
        //加密当前时间
        long now=System.currentTimeMillis();
        long exp=now+1000*5;
        JwtBuilder builder= Jwts.builder()
                .claim("userImg","111")
                .signWith(SignatureAlgorithm.HS256,signkey)
                .setExpiration(new Date(exp));//用于设置过期时间
        System.out.println(builder.compact());
        //解密
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        Claims body=Jwts.parser().setSigningKey(signkey).parseClaimsJws(builder.compact()).getBody();
        System.out.println(body);

    }
}
