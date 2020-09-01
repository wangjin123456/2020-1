package com.taotao.async_log.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 异步写日志文件
 */
public class LogException {
    private static final String path = "d://data/aa.log";

    public static void writeErrorMsg(String content) {
        writeErrorMsg(path, content);
    }


    /**
     * @param path
     * @throws IOException
     * @将错误信息输入到txt中
     */
    public static void writeErrorMsg(String path, String content) {

        File F = new File(path);
        //如果文件不存在,就动态创建文件
        if (!F.exists()) {
            try {
                F.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fw = null;
        String writeDate = "时间:" + getNowDate() + "---" + "error:" + content;
        try {
            //设置为:True,表示写入的时候追加数据
            fw = new FileWriter(F, true);
            //回车并换行
            fw.write(writeDate + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * @return
     * @获取系统当前时间
     */
    public static String getNowDate() {

        Calendar D = Calendar.getInstance();
        int year = 0;
        int moth = 0;
        int day = 0;
        year = D.get(Calendar.YEAR);
        moth = D.get(Calendar.MONTH) + 1;
        day = D.get(Calendar.DAY_OF_MONTH);
        String nowDate = String.valueOf(year) + "-" + String.valueOf(moth) + "-" + String.valueOf(day);
        return nowDate;
    }

    public static void main(String[] args) {
        writeErrorMsg("mayikt");
    }

}
