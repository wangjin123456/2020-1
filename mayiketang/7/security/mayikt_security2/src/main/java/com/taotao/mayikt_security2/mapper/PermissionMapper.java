package com.taotao.mayikt_security2.mapper;


import com.taotao.mayikt_security2.entity.PermissionEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface PermissionMapper {

    @Select(" select * from sys_permission ")
    List<PermissionEntity> findAllPermission();

}
