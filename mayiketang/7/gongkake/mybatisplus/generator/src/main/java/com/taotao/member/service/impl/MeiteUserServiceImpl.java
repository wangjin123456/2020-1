package com.taotao.member.service.impl;

import com.taotao.member.entity.MeiteUser;
import com.taotao.member.mapper.MeiteUserMapper;
import com.taotao.member.service.IMeiteUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-09
 */
@Service
public class MeiteUserServiceImpl extends ServiceImpl<MeiteUserMapper, MeiteUser> implements IMeiteUserService {

     @Autowired
     public MeiteUserMapper meiteUserMapper;
    @Override
    public MeiteUser findByUser(Integer userId) {
        return meiteUserMapper.selectById(userId);
    }
}
