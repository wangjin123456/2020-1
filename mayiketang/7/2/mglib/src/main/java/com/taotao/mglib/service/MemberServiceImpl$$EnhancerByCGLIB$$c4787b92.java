package com.taotao.mglib.service;

import java.lang.reflect.Method;

import com.taotao.mglib.service.impl.MemberServiceImpl;
import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/* compiled from: <generated> */
public class MemberServiceImpl$$EnhancerByCGLIB$$c4787b92 extends MemberServiceImpl implements Factory {
    private static Object CGLIB$CALLBACK_FILTER;
    public static Object CGLIB$FACTORY_DATA;
    private static final Callback[] CGLIB$STATIC_CALLBACKS = null;
    private static ThreadLocal CGLIB$THREAD_CALLBACKS = null;
    private static final Method CGLIB$addMember$0$Method = null;
    private static final MethodProxy CGLIB$addMember$0$Proxy = null;
    private static final Method CGLIB$clone$4$Method = null;
    private static final MethodProxy CGLIB$clone$4$Proxy = null;
    private static final Object[] CGLIB$emptyArgs = null;
    private static final Method CGLIB$equals$1$Method = null;
    private static final MethodProxy CGLIB$equals$1$Proxy = null;
    private static final Method CGLIB$hashCode$3$Method = null;
    private static final MethodProxy CGLIB$hashCode$3$Proxy = null;
    private static final Method CGLIB$toString$2$Method = null;
    private static final MethodProxy CGLIB$toString$2$Proxy = null;
    private boolean CGLIB$BOUND;
    private MethodInterceptor CGLIB$CALLBACK_0;

    public MemberServiceImpl$$EnhancerByCGLIB$$c4787b92() {
        CGLIB$BIND_CALLBACKS(this);
    }

    private static final void CGLIB$BIND_CALLBACKS(Object obj) {
        MemberServiceImpl$$EnhancerByCGLIB$$c4787b92 memberServiceImpl$$EnhancerByCGLIB$$c4787b92 = (MemberServiceImpl$$EnhancerByCGLIB$$c4787b92) obj;
        if (!memberServiceImpl$$EnhancerByCGLIB$$c4787b92.CGLIB$BOUND) {
            memberServiceImpl$$EnhancerByCGLIB$$c4787b92.CGLIB$BOUND = true;
            Object obj2 = CGLIB$THREAD_CALLBACKS.get();
            if (obj2 == null) {
                obj2 = CGLIB$STATIC_CALLBACKS;
                if (obj2 == null) {
                    return;
                }
            }
            memberServiceImpl$$EnhancerByCGLIB$$c4787b92.CGLIB$CALLBACK_0 = (MethodInterceptor) ((Callback[]) obj2)[0];
        }
    }


    public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
        String obj = signature.toString();
        switch (obj.hashCode()) {
            case -508378822:
                if (obj.equals("clone()Ljava/lang/Object;")) {
                    return CGLIB$clone$4$Proxy;
                }
                break;
            case 919144156:
                if (obj.equals("addMember(Ljava/lang/String;)Ljava/lang/String;")) {
                    return CGLIB$addMember$0$Proxy;
                }
                break;
            case 1826985398:
                if (obj.equals("equals(Ljava/lang/Object;)Z")) {
                    return CGLIB$equals$1$Proxy;
                }
                break;
            case 1913648695:
                if (obj.equals("toString()Ljava/lang/String;")) {
                    return CGLIB$toString$2$Proxy;
                }
                break;
            case 1984935277:
                if (obj.equals("hashCode()I")) {
                    return CGLIB$hashCode$3$Proxy;
                }
                break;
        }
        return null;
    }



    @Override
    public final String addMember(String str) {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor == null) {
            return super.addMember(str);
        }
        try {
            return (String) methodInterceptor.intercept(this, CGLIB$addMember$0$Method, new Object[]{str}, CGLIB$addMember$0$Proxy);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  null;
    }


    @Override
    public Object newInstance(Callback callback) {
        return null;
    }

    @Override
    public Object newInstance(Callback[] callbacks) {
        return null;
    }

    @Override
    public Object newInstance(Class[] classes, Object[] objects, Callback[] callbacks) {
        return null;
    }

    @Override
    public Callback getCallback(int i) {
        return null;
    }

    @Override
    public void setCallback(int i, Callback callback) {

    }

    @Override
    public void setCallbacks(Callback[] callbacks) {

    }

    @Override
    public Callback[] getCallbacks() {
        return new Callback[0];
    }
}