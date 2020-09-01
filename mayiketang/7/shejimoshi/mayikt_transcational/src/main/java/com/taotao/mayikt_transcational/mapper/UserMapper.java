package com.taotao.mayikt_transcational.mapper;


import com.taotao.mayikt_transcational.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserMapper
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/

public interface UserMapper {

    @Select(" SELECT * FROM meite_user WHERE USER_ID=#{userId}")
    UserEntity findByUser(Integer userId);

    @Insert("insert into meite_user values(null,#{name}) ")
    int insertUser(UserEntity user);
}
