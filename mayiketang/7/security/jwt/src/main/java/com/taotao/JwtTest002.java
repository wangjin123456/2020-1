package com.taotao;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 *@author tom
 *Date  2020/6/13 0013 12:36
 *
 */
public class JwtTest002 {
    private static  final  String signkey="mayikt_signkey";

    public static void main(String[] args) {
         String jwttoken="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW1nIjoic3NzIiwiaWF0IjoxNTkyMDIzMTY5fQ.HVak2V-cnrsIUS2SJ7VS0rHg8y2e1lE3duDkdaZQmRA";
        Claims body= Jwts.parser().setSigningKey(signkey).parseClaimsJws(jwttoken).getBody();
        System.out.println(body.get("userImg"));
    }

}
