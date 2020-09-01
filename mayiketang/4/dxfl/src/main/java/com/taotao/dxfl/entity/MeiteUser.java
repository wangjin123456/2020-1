package com.taotao.dxfl.entity;

/**
 *@author tom
 *Date  2020/8/22 0022 10:26
 *
 */

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2020-06-09
 */
@TableName("meite_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeiteUser implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer userId;

    private String userName;

    private Integer userAge;

    private String userAddres;

    private LocalDateTime createTime;

    /**
     * 逻辑删除
     * 0存在 1 隐藏
     */
    @TableLogic
    private Integer deleted = 0;
    // 版本
 /*   @Version
    private Integer version;*/

}