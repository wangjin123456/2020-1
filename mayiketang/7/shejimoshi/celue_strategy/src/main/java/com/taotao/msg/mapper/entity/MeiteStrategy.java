package com.taotao.msg.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName MeiteStrategy
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Data
@TableName("meite_strategy")
public class MeiteStrategy {
    private Long id;
    private String strategyName;
    private String strategyId;
    private String strategyType;
    private String strategyBeanId;

    @TableLogic
    private Integer deleted=0;
}
