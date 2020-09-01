package com.taotao.mayikt_security;

import com.taotao.mayikt_security.utils.SignUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 *@author tom
 *Date  2020/6/7 0007 22:02
 *
 */
public class Test002 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String value= DigestUtils.md5Hex("123456"+"客户端会的");
        System.out.println(value);
        HashMap<String,String> objectHashMap=new HashMap<>();
        objectHashMap.put("amount",1000+"");
        Map<String,String>sign= SignUtil.sign(objectHashMap);
        System.out.println(sign.toString());
        String encode= URLEncoder.encode("mayikt+meite","UTF-8");
        System.out.println(encode);
        String decode= URLDecoder.decode(encode,"UTF-8");
        System.out.println(decode);

    }
}
