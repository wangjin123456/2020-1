package com.taotao.service.impl;

import com.taotao.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/5/1 0001 9:30
 *
 */
@RestController
public class IndexServiceImpl implements IndexService {
    @GetMapping("/index")
    public String index() {
        return "hello world";
    }
}
