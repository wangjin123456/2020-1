package com.taotao.springspringsecurity.mapper;

import com.taotao.springspringsecurity.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

	// 查询苏所有权限
	@Select(" select * from sys_permission ")
	List<Permission> findAllPermission();

}
