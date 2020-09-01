package com.taotao.mayikt_security2.service;

import com.taotao.mayikt_security2.entity.PermissionEntity;
import com.taotao.mayikt_security2.entity.UserEntity;
import com.taotao.mayikt_security2.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *@author tom
 *Date  2020/6/11 0011 12:19
 *
 */
@Slf4j
@Component
public class MemberUserDetailsService implements UserDetailsService {
 @Autowired
 private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1, 根据用户名称查询数据库中是否存在
        UserEntity userEntity=userMapper.findByUsername(username);
        if(userEntity==null){
            return  null;
        }

        //2 需要做连表查询对应用户的权限
        List<PermissionEntity> permissionEntityList=userMapper.findPermissionByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        permissionEntityList.forEach((user)->{
            user.getPermTag();
            authorities.add(new SimpleGrantedAuthority(user.getPermTag()));
        });
             log.info(">>>>>>>>>>>>>{}<<<<<<<<<<<",authorities);
         //使用该权限加到security
        userEntity.setAuthorities(authorities);
        return userEntity;
    }

    public static void main(String[] args) {
       /* UserDetailsService userDetailsService=(username)->{
            return null;
        };*/
    }
}
