package com.taotao.springbootes.dao;

import com.taotao.springbootes.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *@author tom
 *Date  2020/5/23 0023 9:38
 *
 */
public interface UserDao  extends CrudRepository<UserEntity,String> {




}
