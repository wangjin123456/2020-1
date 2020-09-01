package com.taotao.taotaomembers.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tom
 * Date  2020/4/15 0015 14:56
 */
@Data
public class UserEntity  implements Serializable {
    private static final long serialVersionUID = -51863096759936799L;
    /**
     * userid
     */
    private Long userid;
    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码
     */

    private String password;
    /**
     * 用户名称
     */

    private String userName;
    /**
     * 性别 0 男 1女
     */

    private char sex;
    /**
     * 年龄
     */

    private Long age;
    /**
     * 注册时间
     */

    private Date createTime;
    /**
     * 修改时间
     */

    private Date updateTime;
    /**
     * 账号是否可以用 1 正常 0冻结
     */
    private char is_avalible;
    /**
     * 用户头像
     */

    private String pic_img;
    /**
     * 用户关联 QQ 开放ID
     */
    private Date qq_openid;
    /**
     * 用户关联 微信 开放ID
     */

    private Date WX_OPENID;
}
