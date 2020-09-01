package com.taotao.mybatisplus1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
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
@Data
@EqualsAndHashCode(callSuper = false)
public class MeiteUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

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
    @Version
    private Integer version;

}
