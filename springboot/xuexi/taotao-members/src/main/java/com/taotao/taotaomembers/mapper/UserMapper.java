package com.taotao.taotaomembers.mapper;

import com.taotao.taotaomembers.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



/**
 * @author tom
 * Date  2020/4/15 0015 15:15
 */

public interface UserMapper {
    @Insert("    INSERT INTO `test`.`meite_user` ( `mobile`, `password`, `userName`, `sex`, `age`, `createTime`, `updateTime`, `is_avalible`, `pic_img`, `qq_openid`, `WX_OPENID`) VALUES (#{mobile},  #{password}, #{userName},  NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);")
    int register(UserEntity userEntity);

    @Select("SELECT * FROM meite_user WHERE MOBILE=#{mobile};")
    UserEntity existMobile(@Param("mobile") String mobile);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,PASSWORD AS PASSWORD, USER_NAME AS USER_NAME ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID "
            + "  FROM meite_user  WHERE MOBILE=#{mobile} and password=#{password};")
    UserEntity login(@Param("mobile") String mobile, @Param("password") String password);
}

