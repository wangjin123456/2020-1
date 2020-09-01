package com.taotao.anhuiquanzi1.controller;

import com.taotao.anhuiquanzi1.util.IdWorker;
import com.taotao.anhuiquanzi1.util.PhotoDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tom
 * @date 2020/4/9 0009 16:15
 */
@RestController
public class IdController {

    @RequestMapping("/index")
    public void index() {
        IdWorker idWorker = new IdWorker(1, 1, 1);
        for (int i = 0; i < 30; i++) {
            System.out.println(idWorker.nextId());
        }
    }

    @RequestMapping("/photodigest")
    public static void photodigest() {
        PhotoDigest.compareImage("D:\\data\\1.jpg", "D:\\data\\3.jpg");
    }

    public  void map(){
        Map map=new HashMap();
        Map map1=new TreeMap();
    }
}
