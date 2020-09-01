package com.mayikt.mtshopservicepay.api.pay.impl.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 *@author tom
 *Date  2020/4/21 0021 0:49
 *
 */
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String APP_ID = "2016102400750162";

    // 商户私钥，您的PKCS8格式RSA2私钥，这些就是我们刚才设置的
    public static String MERCHANT_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdoPOAX5MEkkhG3EmWsPPwPvpFcgC+gK2yhxgC5/mHityJSvMsYDVMG3bgMB+mpAd00qxBIL49KqWBIndabWP50oNnmX+jsblHQEfC8egFPijhOuGNlOsXWEsMupUH4+J+8QCHAFBWgrXzTb6LuVQnqRgXx8Gw3XC1iLuutNsoClk/tncJeN+7rUGraEp2IhsQB9pPcs1CZn0c7EVcFXRrJ8lGu18ze7jbb0hx6EqnhZ8LIlI+B+irYVsWGH7NQdHMnsb4dxmLr/YytVp1PQdEpBvBblHUUTlDUq0WGZ3jGEmx+G8OQ5jktLvuylWfTSwUHzWQWHwvC3rJ5hLh/Y7RAgMBAAECggEAAs8rh84sQJia0Sh750OgFVgJ/dLaUIrajaP6uZKIz/GZnJjJXLEaQhD7PWOeLMofl+VpTH/Y5B4udO64UdRBQ+KMlPwXWkOAmdR7cu38xJsm/1ydSHiu9+uK6t8oaMuW7cw9xiorRF9v/rYT/0l+RnatBz94JD7OE24saiCvBzeg1kT/6Hqn0eiFIreID5gYPwkr8VCDH2Cl4IdSyTXUxSErlDAfermuEpkXs42BNjJRI3swwtmNqGjQ09DdPED8DfG0X0Z2uO61qcIqNx8HZIUYZ7JzZtTfFRNLWGhYp3waxigzssXfeKegqNWXT0J1Y4QIGNYQvP+XAb1WHgJUAQKBgQDMVUvOLJ6XVGc5v3TPBFu6tQKUZo4u9XWxqLEwY8HLfDRz+fbCLRNWkdQOOaZ//OnpN2q/UMOeAUdibpp4um/ccB9K0k5u/LLhUH1KB+PAXkdY6Nzb733xQCqpFZ7rVKtW3WIGxIMjth04v95CsTmZTA74QFKuOhBD3o9CkzlK2QKBgQDFfGzP/ZsYD4ceAbkCplfyFJKlzZ2CRRm5qXJ3C3qti3TubUWQIHR7priIGw+myWV/9BVUO6nhB14VcoTOmHh3WXt4bW19GhJuNKrrUsZQpICA6zrdEJngIjJxp/+5m2jyVbBNVa5ufbGGlsH1z+F1atIT6roP6mOKytNWlo84uQKBgE5jcp938qdvk+JNlsxMibxI8OJpraZKOIqdgsxjmNctoRnVDVtU25RcgZOrfjqflkUII4WdwE3/g5k5gT1LmNpikT6tC7X8b8uMi2Q5PqBwCsMLIp+lcxV4XmVbjAoQA2NhrteV0BGFLhS1VtkTEFvFGAEY/B8m21KOMTuDK3mRAoGBAKH/b0Muxgr2sd/ridiim4H5XlKkWJCEHpYuabc9s2SpAUKUYHvaI7NLEBSWHkCy9JABqX1vc+skIAl353mRmUBOJvqiyS3WNUgx7AMd45BDYSZfz+mHtLInWzngleWrlmsz32uQ3YXFldrR0EnUPR4Ugj/UTMzBeOZhevuMhfABAoGAE55JOKyb6eEKvw1rLsqrXIFdK/Yq6dvGuX3QxuJIowwuIgdfZ5zHR7Pf8c8148x050p/eLE4F/bOPdc4HOJ91RLvQkSoeVN29QHJ1qpxR6fAc+ITwrzxEMl1wLYUc6TwvTRF4BOBNxdhket/Lr+W+rGL06qp59qJFKC9FHb2YSc=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。，这些就是我们刚才设置的
    public static String ALIPAY_PUBLIC_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmCQI15Z4o3QtcTYgpf5kSZZgNxR2KEG+K6HtbruY9ry3HlRamGt7vAx1ROp/pvbp71G3E6zeas9tCduZV8pbezoYbKUprMtl8uQ3h2KcyvIQmfFKf1NETGjNvRQY5e6Am2eTm8+yMwcnoyKTPvQUnrzqmUJ9W5WGu3HP2RZUvsp1/JzZmBQ38MsOxLZgkqlToer/cnK8wdY5yTO4rhX46TcQj9dpBpx+t/u61xNduHPCg1fSUz37G8GWRpJ2ne62W2+ZHD1BcyvijPQJDwIKwlCfEX9GOiiNQ18bue2VryUHhObzTGLZ4om3gpC0W4q4oX8jCB5xQW8v1WNqclkgAQIDAQAB";
    //异步通知，再这里我们设计自己的后台代码
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String SIGN_TYPE = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关
    public static String GATEWAYURL = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String LOG_PATH = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(LOG_PATH + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
