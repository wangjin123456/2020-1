package com.taotao.service;

import com.taotao.ext.ExtAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/22 0022 9:09
 *
 */
@Component

public class MemberServiceMessage {

    @ExtAsync
    public static String addUserLog(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        System.out.println("》》》》》》》》》流程2");
        return  "success";
    }
}
