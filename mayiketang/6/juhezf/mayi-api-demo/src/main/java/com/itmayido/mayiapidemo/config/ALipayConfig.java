package com.itmayido.mayiapidemo.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 *@author tom
 *Date  2020/4/19 0019 15:45
 *支付的配置信息
 */
public class ALipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 2016101500694608
    public static String APP_ID = "2016101500694608";

    // 商户私钥，您的PKCS8格式RSA2私钥，这些就是我们刚才设置的
    public static String MERCHANT_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCU726Bhiipxxkab1EKFTMT1qBcvH+k5Y/yzH4qYXJgdVSbB1lkPMDKnMl0uQZ7F35mASaOr2fGv7Czq52eP2ZEBnHTmXxGyctS8Qr/08InNdwbTg8Qb47aA+SMr+ZCoueYUby7i2USrAMnNSPtPRy6sCc+VSrxZPYw383T3EUeZoLxlAdhDD/IekPf/jDkEnoAKuzEbomVt5m9MDPwbhNE5VqDGYmjGpQ6Riri2mXOD2FBG1AV+mh5hWkhWGOOT+hQ1CAZEj0jQSN0Wsh5w9Ker3gjVr4s2GAFV4vMpHCRsQNOLQ0l2pwvWUVqpzy65nbQ8NgDPWLi8jyCy7Blutq5AgMBAAECggEAPF2Leb4pzx6eoyNJQn/zMvBEETJpvik5nhyaao0Ssdv8jdV9uu4Q6k6ALOotoUiVd7yxpxWbR2g8s6Y0fYaO6bV+/1fvkjWKTrTaU3S99eyTqRGLc4rz6JO5V/iXqJykqA1BJPbL4bSMlqCoTij98wEg9tfITw0v6AFeSKe38CjXe3Ywg+eMb/y22mmbRste5FrzhGi8OaYzkuCVFG/CvbWiW1unzupkgkLt8XLbjzpVKVh85/Ai18p5vggC9fGoFIhYkDGNGDvByGWgKNmX1g46STjPY+VtXlej96pUGMYouVsfv6AnrjQ8vdhp4wyKCWJP+8FoWfx/Fr8gA/4hgQKBgQDYcds3ns9nAEhXcwK2kQZO8NkPZkuyr4JD+Eqva812VjCvV2xKk2+H4jOyfMjBMPlp8bK88GVHMfSxUaA1kTU1/SiwghxSQveg0ekfME5hHnZR4eG2cUlNiPhDdXXSvuqFlwlGmrwIk2aCsS1CGfQKedgh+gyG5oJAxmCZZtwXUQKBgQCwJzbv8mylNO7eGmxiPIwlql5sbrNRdv9c8sJ+2d9QCktPrC6+TJWrERj+Lq8vxKYNU0RQ89zJYvYoJoRPldev4wDrVtTx52ap2RCxgMyqWw0JFCj+jQzbnMEF1FdMbKAZqfUIaIWZIMNTV/GfADgGLw8jNV1/wHIX3YzD8ssC6QKBgQCP/4eZxHU1kJGQZHrMnUV2JXQzc5ovAecHc1u0w2LJNORk8yOfpeEQpSRBvhUNuphkrKF+Y+ztZcXmZmjQ2o9tIMT+UUGoVNdMTfrrfgbXRB3xsfapm0rqY5LPxoihsdRzFh3ctDse9XnAv0Fd9chPY+qwCBxnb1n+4DwKMs2AUQKBgHZxR607EfZbiyloFuxOzeUdkvPR01y5aKb0y/ZDRLYq1cyyd5OZJyGpE2cFuOGjlgtrq4nLDu+STPVeQKTKmgY32oxjDDfDYfJec60Gb5c0NaWfGpld+gFIezkSN8i5WUUoVAvdS8dUkkFd5qcEnKb7yW/hGAcoPQ7y9w1iGULRAoGAf/Iiomp2c6INwvXQ+NvcTJ848y8+LoFLqFwwh5MpPmZplr8K2WQL6MuGIQyhZ+3WLE6FrvREIxiKnAFI1VzhpsNOevRH8g1t0DT/jpd8bOANm+O4Xrd+d3Ou/m9KJCYUVJSu4uiudghDXsKQvL+p1Av0nBdFDTYe5ZQE6PVE9js=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。，这些就是我们刚才设置的
    public static String ALIPAY_PUBLIC_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlHhCAFV61ECOTgcFlpcLc1fSwz6Hty1gUhWVBsDAgq2Q9jU59VxacjeHv82dWIxvPJKa/jJ+zG9bakiA+hGMw0FsZM6Kp5l6FZ3TOtlscKUc403iSW89BmGGAxX3W0otIEYxuJ/5nIlBbu+/PSLg/oCV7X4tyoRtJZiNjgRCIJ69ztIlI6Tk9DBm/d5Y89Y2lzqjuWip2ZbnSAC5q519+pb6MsbfQ/sPV3GK+IUgHliKQyq5xVqTJ5yB/0WA0GzV3XT9cecffJe4sAG6qn/GsJcaN5KG36RNeUGjNljL/bSx+YMqmLxIZmI9T3ZKfcR1tqYkE//kxv4k0+zJoqegdQIDAQAB";
    //异步通知，再这里我们设计自己的后台代码
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String SIGN_TYPE = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关https://openapi.alipay.com/gateway.do
    public static String GATEWAYURL = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String LOG_PATH = "D:\\pay";



    public  static  void logResult(String sWord) throws IOException {
        FileWriter writer=null;
        try {
            writer=new FileWriter(LOG_PATH+"alipay_log_"+System.currentTimeMillis()+".text");
            writer.write(sWord);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
    }
}
