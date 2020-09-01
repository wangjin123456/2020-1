package com.taotao.member.service;

import com.taotao.member.entity.MeiteUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-06-09
 */
public interface IMeiteUserService extends IService<MeiteUser> {

    MeiteUser findByUser(Integer userId);
}
