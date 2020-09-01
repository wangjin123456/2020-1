package com.taotao.mayikt_observer.observer;

import com.alibaba.fastjson.JSONObject;

/**
 *@author tom
 *Date  2020/5/26 0026 23:39
 *
 */
public interface Observer {
    void sendMsg(JSONObject jsonObject);
}
