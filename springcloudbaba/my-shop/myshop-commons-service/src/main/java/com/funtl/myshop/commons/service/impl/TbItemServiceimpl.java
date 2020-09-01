package com.funtl.myshop.commons.service.impl;

import com.funtl.myshop.commons.domain.TbItem;
import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.mapper.TbItemMapper;
import com.funtl.myshop.commons.mapper.TbUserMapper;
import com.funtl.myshop.commons.service.TbItemService;
import com.funtl.myshop.commons.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * @author tom
 * @date 2020/3/31 0031 11:38
 */
@Service
public class TbItemServiceimpl  extends  BaseCrudServiceImpl<TbItem, TbItemMapper> implements TbItemService {
}
