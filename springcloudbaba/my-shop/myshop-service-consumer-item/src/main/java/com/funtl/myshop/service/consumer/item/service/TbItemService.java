package com.funtl.myshop.service.consumer.item.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tom
 * @date 2020/3/31 0031 15:01
 */
@FeignClient(value = "myshop-service-provider-item")
public interface TbItemService {
    @GetMapping(value = "/item/page/{num}/{size}")
    String page(@PathVariable(name = "num")int pageNum,@PathVariable(name="size")int size);
}
