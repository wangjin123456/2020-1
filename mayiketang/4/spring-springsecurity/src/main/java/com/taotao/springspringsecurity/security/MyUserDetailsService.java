package com.taotao.springspringsecurity.security;

import com.taotao.springspringsecurity.entity.Permission;
import com.taotao.springspringsecurity.entity.User;
import com.taotao.springspringsecurity.mapper.PermissionMapper;
import com.taotao.springspringsecurity.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *@author tom
 *Date  2020/5/20 0020 8:29
 *设置动态用户信息
 */
@Service
@Slf4j
public class MyUserDetailsService  implements UserDetailsService {
   @Resource
   private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userNmae) throws UsernameNotFoundException {
        //1.根据用户名称查询数据用户信息
        User user=userMapper.findByUsername(userNmae);
        //2 底层会根据数据库查询用户信息，判断密码是否正确
        //3，给用户设置权限
        List<Permission> permissionList=userMapper.findPermissionByUsername(userNmae);
     log.info("userNmae"+userNmae+"对应权限"+permissionList.toString());
          if(permissionList !=null && permissionList.size()>0){
             //定义用户权限
              List <GrantedAuthority> authorities=new ArrayList<>();
              for (Permission permission: permissionList) {
              authorities.add(new SimpleGrantedAuthority(permission.getPermTag()));
          }
              user.setAuthorities(authorities);

        }
        return user;
    }
}
