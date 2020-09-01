package com.taotao.dxfl.mapper;



import com.taotao.dxfl.entity.MeiteUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


/**
 *@author tom
 *Date  2020/8/22 0022 10:27
 *
 */

public interface MeiteUserMapper extends BaseMapper<MeiteUser> {
    @Select("select * from meite_user where user_id=27")
            MeiteUser select(Integer userId);



    @Insert("INSERT INTO `test`.`meite_user`( `user_name`, `user_age`, `user_addres`, `create_time`, `deleted`, `version`) VALUES ( '1', 19, '上海市', '2020-04-22 15:45:52', 1, 0);\n")
    void add(MeiteUser user);

}
