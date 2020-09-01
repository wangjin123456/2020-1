package com.mayikt;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflexUtils
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class ReflexUtils {

    public static Object newInstance(Class classInfo) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 1.使用java的反射技术拼接orderService源代码
        StringBuffer sf = new StringBuffer();
        sf.append("package com.mayikt;");
        String simpleName = classInfo.getSimpleName() + "Impl";
        sf.append("public class " + simpleName + " implements " + classInfo.getSimpleName() + " { ");
        Method[] methods = classInfo.getMethods();
        for (Method method :
                methods) {
            sf.append("@Override");
            sf.append(" public " + method.getReturnType().getSimpleName() + "  " + method.getName() + " " +
                    " (String ver1, String ver2) {" +
                    " return \"meite\";}");
        }
        sf.append("}");
        // 2.将java源代码写入到硬盘中
        String filename = "d:/code/" + simpleName + ".java";
        File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        fw.write(sf.toString());
        fw.flush();
        fw.close();
        // 3.编译class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(filename);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();
        // 4.使用类加载器将该class文件读取到内存中国
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        Class<?> aClass = javaClassLoader.findClass(simpleName);
        Object object = aClass.newInstance();
        return object;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IOException {

//        Class userClass = UserEntity.class;
//        System.out.println(userClass.getSimpleName());
//        Class<?> classInfo = Class.forName("com.mayikt.entity.UserEntity");
//        System.out.println(classInfo.getSimpleName());
//        Class<? extends UserEntity> aClass = new UserEntity().getClass();
//        System.out.println(aClass.getSimpleName());\
        //使用java的反射技术new对象
//        Class<?> classInfo = Class.forName("com.mayikt.entity.UserEntity");
////        // 实例子化对象 无参构造函数 默认执行就是无参构造函数
//        UserEntity userEntity = (UserEntity) classInfo.newInstance();
////        userEntity.setUserName("mayikt");
////        System.out.println(userEntity.getUserName());
////        Constructor<?> constructor = classInfo.getConstructor(String.class,Integer.class);
////        UserEntity userEntity = (UserEntity) constructor.newInstance("每特教育666",644064779);
////        System.out.println(userEntity.getUserName()+","+userEntity.getUserId());
//        // 使用反射给属性赋值
////        Field field = classInfo.getDeclaredField("userName");
////        // 设置权限
////        field.setAccessible(true);
////        field.set(userEntity, "每特教育就是6666");
////        System.out.println(userEntity.getUserName());
//        Method addUserMethod = classInfo.getDeclaredMethod("addUser", String.class);
//        addUserMethod.setAccessible(true);
//        addUserMethod.invoke(userEntity, "mayikt");
        OrderService orderService = (OrderService) newInstance(OrderService.class);
        String s = orderService.addOrder("mayikt", "meite");
        System.out.println(s);
    }
}
