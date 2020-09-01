package com.taotao.bkproxy.jdk;

        import com.taotao.bkproxy.proxy.MyProxy;
        import com.taotao.bkproxy.service.OrderService;
        import com.taotao.bkproxy.service.impl.OrderServiceImpl;

        import java.lang.reflect.InvocationHandler;
        import java.lang.reflect.Method;
        import java.lang.reflect.Proxy;

/**
 *@author tom
 *Date  2020/5/17 0017 23:55
 *
 */
public class JdkInvocationHandler implements InvocationHandler {
    //目标对象，需要代理的对象‘
    private Object object;

    public JdkInvocationHandler(Object object) {
        this.object = object;
    }

    /***
     * java jdk 动态代理生成代理对象proxy
     * @param proxy
     * @param method  目标方法 通过反射实现
     * @param args 目标方法需要传递的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理继承模式方式开始：");
        Object o = method.invoke(object, args);//目标方法
        System.out.println("jdk动态代理调用方法结束：");
        return o;
    }


    /**
     * 通过jdk 动态代理反射技术生成代理对象，调用代理对象的方法的时候会走InvocationHandlerinvoke方法
     * @param <T>
     * @return
     */
    public  <T> T getProxy(){
        return  (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this::invoke);
    }

    public static void main(String[] args) {
        MyProxy.newProxyInstance(null, OrderService.class,null);
    }
}
