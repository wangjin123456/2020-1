package com.funtl.myshop.commons.service.impl;

import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.mapper.TbUserMapper;
import com.funtl.myshop.commons.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * @author tom
 * @date 2020/3/27 0027 19:01
 */
@Service
public class TbUserServiceImpl extends  BaseCrudServiceImpl<TbUser, TbUserMapper> implements TbUserService {
}
