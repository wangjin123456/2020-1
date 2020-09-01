package com.taotao.bkproxy.proxy;

import com.taotao.bkproxy.jdk.ExtMyInvocationHandler;
import com.taotao.bkproxy.service.OrderService;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *@author tom
 *Date  2020/5/18 0018 7:48
 *
 */
public class MyProxy {
    private static String rt = "\r\t";
    private  File classpathFile;

    /**
     *
     * @param javaClassloader 加载我们生成好的class文件
     * @param classInfo 根据接口生成代理类
     * @param h
     * @return
     */
    public static Object newProxyInstance(JavaClassLoader javaClassloader,
                                          Class<?> classInfo,
                                          ExtMyInvocationHandler h) {
        try {
            //1, 使用java反射机制拼接$Proxy.java类的源码
            Method[] methods = classInfo.getMethods();
            String proxyClass = "package com.taotao.bkproxy.proxy;" + rt
                    + "import java.lang.reflect.Method;" + rt
                    + "import com.taotao.bkproxy.jdk.ExtMyInvocationHandler;" + rt
                    + "import java.lang.reflect.UndeclaredThrowableException;" + rt
                    + "public class $Proxy0 implements " + classInfo.getName() + "{" + rt
                    + "ExtMyInvocationHandler h;" + rt
                    + "public $Proxy0(ExtMyInvocationHandler h)" + "{" + rt
                    + "this.h= h;" + rt + "}"
                    + getMethodString(methods, classInfo) + rt + "}";
            // 2. 将代理类源码文件写入硬盘中
            String filename="D://data//$Proxy0.java";
            File f =new File(filename);
            FileWriter fw=new FileWriter(f);
            fw.write(proxyClass);
            fw.flush();
            fw.close();
            // 3.需要将$Proxy.java编译成$Proxy.class
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(filename);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();
            // 4.将class文件加入到内存中
            Class proxy0Class = javaClassloader.findClass("$Proxy0");
            //5.使用java反射机制给函数中赋值
            Constructor m = proxy0Class.getConstructor(ExtMyInvocationHandler.class);
            Object o = m.newInstance(h);
            return o;

        } catch (Exception e){
            e.getCause();
        }

        return  null;
    }


    public static String getMethodString(Method[] methods, Class intf) {
        String proxyMe = "";

        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parameterTypes.length; i++) {
                sb.append(parameterTypes[i].getName() + " ver" + (i + 1));
                if (i < parameterTypes.length - 1) {
                    sb.append(" ,");
                }

            }
            String parameterStr = sb.toString();
            proxyMe = "public " + method.getReturnType().getName() + " " + method.getName() + " ( " + parameterStr + " ) { " +
                    "try {   Method m3 = Class.forName(\"com.taotao.bkproxy.service\").getMethod(\"addOrder\", Class.forName(\"java.lang.String\"), Class.forName(\"java.lang.String\"));" +
                    "return (String) h.invoke(this, m3, new Object[]{ver1, ver2}); } catch (RuntimeException | Error var4) {  throw var4;  } catch (Throwable var5) {   throw new UndeclaredThrowableException(var5); } " +
                    "" +
                    " } ";

        }
        return proxyMe;
    }
    public static void main(String[] args) {
        MyProxy.newProxyInstance(null, OrderService.class, null);
    }
}
