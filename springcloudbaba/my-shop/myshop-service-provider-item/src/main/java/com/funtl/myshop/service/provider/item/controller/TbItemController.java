package com.funtl.myshop.service.provider.item.controller;

import com.funtl.myshop.commons.domain.TbItem;
import com.funtl.myshop.commons.service.TbItemService;
import com.funtl.myshop.commons.web.AbstractBaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tom
 * @date 2020/3/31 0031 10:53
 */
@RestController
@RequestMapping(value = "item")
public class TbItemController extends AbstractBaseController {
    @Autowired
    private TbItemService tbItemService;

    @ApiOperation(value = "商品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "笔数", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping(value = "page/{num}/{size}")
    public PageInfo<TbItem> page(@PathVariable int num,  @PathVariable int size) {
        PageInfo<TbItem> page = tbItemService.page(null, num, size);
        return  page;
    }


}
