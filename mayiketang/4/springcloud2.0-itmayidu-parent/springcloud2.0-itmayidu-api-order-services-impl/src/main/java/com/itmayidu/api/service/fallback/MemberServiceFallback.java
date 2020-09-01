package com.itmayidu.api.service.fallback;

import com.itmayidu.api.entity.UserEntity;
import com.itmayidu.api.service.feign.MemberServiceFeign;
import com.taotao.BaseApiService;
import com.taotao.ResponseBase;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/4/27 0027 22:17
 *
 */
@Component
public class MemberServiceFallback  extends BaseApiService implements MemberServiceFeign {
    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    @Override
    public ResponseBase getUserInfo() throws InterruptedException {
        return setResultError("服务器忙请稍后再重试，以类的方式进行服务降级");
    }
}
