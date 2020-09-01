package com.taotao.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserEntity
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Data
@TableName("meite_user")
public class UserEntity {

    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;
    private String userName;
    private Integer userAge;
    private String userAddres;
    private Date createTime;

    @TableLogic
    private Integer deleted = 0;
    // 版本
    @Version
    private Integer version;
}
