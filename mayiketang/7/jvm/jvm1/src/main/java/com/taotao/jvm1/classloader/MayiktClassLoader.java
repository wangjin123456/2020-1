package com.taotao.jvm1.classloader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 *@author tom
 *Date  2020/8/8 0008 8:34
 *自定义类加载器
 */
public class MayiktClassLoader  extends  ClassLoader{

 private File fileObject;

    public File getFileObject() {
        return fileObject;
    }

    public MayiktClassLoader setFileObject(File fileObject) {
        this.fileObject = fileObject;
        return this;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {

            byte[] data=getClassFileBytes(this.fileObject);
            return  defineClass(name,data,0,data.length);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * 从文件中读取class
     * @param fileObject
     * @return
     */
    private byte[] getClassFileBytes(File fileObject) throws IOException {
        //采用NIO读取
        FileInputStream fis=new FileInputStream(fileObject);
        FileChannel fileChannel=fis.getChannel();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
        WritableByteChannel outc= Channels.newChannel(baos);
        while (true){
            int i=fileChannel.read(buffer);
            if(i ==0 || i==-1){
                break;
            }
            buffer.flip();
            outc.write(buffer);
            buffer.clear();
        }
        fis.close();
        return  baos.toByteArray();

    }
}
