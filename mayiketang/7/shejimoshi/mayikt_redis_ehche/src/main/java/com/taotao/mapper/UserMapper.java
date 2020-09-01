package com.taotao.mapper;


import com.taotao.entity.UserEntity;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserMapper
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/

public interface UserMapper {

    @Select(" SELECT * FROM meite_user WHERE userId=#{userId}")
    UserEntity findByUser(Integer userId);
}
