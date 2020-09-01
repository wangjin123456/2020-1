package com.taotao.mybatisplus1.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.taotao.mybatisplus1.utils.SnowflakeIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/17 0017 8:25
 *自定义分布式主键id
 */
@Component
public class CustomIdGenerator  implements IdentifierGenerator {
@Autowired
private SnowflakeIdUtils snowflakeIdUtils;
    @Override
    public Long  nextId(Object entity) {
        return snowflakeIdUtils.nextId();
    }
}
