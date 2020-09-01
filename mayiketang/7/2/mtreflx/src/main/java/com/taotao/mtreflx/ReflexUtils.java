package com.taotao.mtreflx;

import com.taotao.mtreflx.entity.UserEntity;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;

/**
 *@author tom
 *Date  2020/6/28 0028 9:22
 *
 */
public class ReflexUtils {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IOException {
        Class userclass = UserEntity.class;
        System.out.println(userclass.getSimpleName());

        Class<?> classInfo = Class.forName("com.taotao.mtreflx.entity.UserEntity");
        System.out.println(classInfo.getSimpleName());
        Class<? extends UserEntity> aclass = new UserEntity().getClass();
        System.out.println(aclass.getSimpleName());
        //实例化对象，无参构造函数
        UserEntity userEntity = (UserEntity) classInfo.newInstance();
        System.out.println(userEntity.getUserId());

        Constructor<?> constructor = classInfo.getConstructor(String.class);
        UserEntity userEntity1 = (UserEntity) constructor.newInstance("每特");
        System.out.println(userEntity1.getUserName());
        //使用反射给属性赋值
        Field field = classInfo.getDeclaredField("userName");
        //设置权限
        field.setAccessible(true);
        field.set(userEntity, "33");
        System.out.println(userEntity.getUserName());
//获取方法
        Method method = classInfo.getDeclaredMethod("addUser", String.class);
        method.setAccessible(true);
        Object mayikt = method.invoke(userEntity, "mayikt");
       OrderService orderService=(OrderService) newInstance(OrderService.class);
        String s=orderService.addOrder("mayikt","meite");
        System.out.println(s);
    }

    public static Object newInstance(Class classInfo) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1，使用java的反射技术拼接OrderService源代码
        StringBuffer sf = new StringBuffer();
        String simpleName = classInfo.getSimpleName() + "Impl";
        sf.append("package com.taotao.mtreflx;");
        sf.append("public class " + classInfo.getSimpleName() + "Impl" + " implements       " + classInfo.getSimpleName() + " {    @Override");
        Method[] methods = classInfo.getMethods();
        for (Method method : methods) {
            sf.append(" public " + method.getReturnType().getSimpleName() + "  " + method.getName() + " (String ver1, String ver2){" + "return \"kfkfk\";}");
        }
        sf.append("}");
        //2将java 源代码写入硬盘
        String fileName = "D://code//" + simpleName + ".java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(sf.toString());
        fw.flush();
        fw.close();
        // 3.编译class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();
        //4使用类加载器将class文件放入程序
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        Class<?> aclass = javaClassLoader.findClass(simpleName);
        Object o = aclass.newInstance();

        return o;


    }
}
