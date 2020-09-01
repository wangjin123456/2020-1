package com.taotao.service;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *@author tom
 *Date  2020/5/1 0001 9:18
 *
 */
public interface IndexService {
    @GetMapping("/index")
    public  String index();
}
