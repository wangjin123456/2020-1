package com.itmayido.mayiapidemo.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.itmayido.mayiapidemo.config.ALipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@author tom
 *Date  2020/4/19 0019 19:17
 *
 */
@Controller
public class PayController {

    /**
     * 支付接口
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/pay")
    public  void alipayTreadeRefundJsp(HttpServletRequest request, HttpServletResponse response)throws  Exception{
         //获得初始化的AlipayClient
        AlipayClient aLipayClient= new DefaultAlipayClient(ALipayConfig.GATEWAYURL,ALipayConfig.APP_ID,ALipayConfig.MERCHANT_PRIVATE_KEY,
                "json",ALipayConfig.CHARSET,ALipayConfig.ALIPAY_PUBLIC_KEY,ALipayConfig.SIGN_TYPE);
         //设置请求参数
        AlipayTradePagePayRequest alipayTradePagePayRequest=new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(ALipayConfig.return_url);
        alipayTradePagePayRequest.setNotifyUrl(ALipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"), "UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"), "UTF-8");
        subject="mayikt";
        //商品描述，可空
        String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"), "UTF-8");

        alipayTradePagePayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayTradePagePayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

           //请求
        String result=aLipayClient.pageExecute(alipayTradePagePayRequest).getBody();
        //输出
        System.out.println("请求的结果"+result);
                response.getWriter().println(result);
    }
}
