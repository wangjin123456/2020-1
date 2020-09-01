package api.service;


import com.taotao.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author tom
 *Date  2020/4/21 0021 23:43
 *
 */
public interface IOrderService {
    /**
     * 订单服务调用会员服务
     */
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);

    /**
     * 订单服务接口调用会员服务接口
     * @return
     */
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() throws InterruptedException;

    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo() throws InterruptedException;
    @RequestMapping("/")
    public String index();
}
