package com.taotao.springbootword.service.impl;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;

import com.taotao.springbootword.mapper.DataSourceMapper;
import com.taotao.springbootword.service.DataSourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
/**
 *@author tom
 *Date  2020/4/18 0018 10:05
 *
 */

@Service
public class DataSourceDetailServiceImpl implements DataSourceDetailService {
    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public List<Map<String, Object>> getDataSourceDetail(String tableName) {
        return dataSourceMapper.getDataDetail(tableName);
    }

    @Override
    public List<Map<String, Object>> getAllDataSourceName(String dbName) {
        return dataSourceMapper.getAllDataSourceName(dbName);
    }

    @Override
    public void toWord(List<Map<String, Object>> tables) {
        Document document = new Document(PageSize.A4);
        try {
            // 创建文件
            String  fileName="D:/data/dbDetail.doc";
            File file = new File(fileName);
            if (file.exists() && file.isFile()) {
                file.delete();
            }

            file.createNewFile();

            // 写入文件信息
            RtfWriter2.getInstance(document, new FileOutputStream(fileName));
            document.open();
            Paragraph ph = new Paragraph();
            Font f = new Font();
            Paragraph p = new Paragraph("数据库表设计文档", new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)));
            p.setAlignment(1);
            document.add(p);
            ph.setFont(f);
            for (int i = 0; i < tables.size(); i++) {
                String table_name = (String) tables.get(i).get("name");
                // 表说明
                String table_comment = (String) tables.get(i).get("comment");
                //获取某张表的所有字段说明
                List<Map<String, Object>> list = this.getDataSourceDetail(table_name);
                String all = "" + (i + 1) + " 表名称:" + table_name + "（" + table_comment + "）";
                Table table = new Table(6);
                document.add(new Paragraph(""));

                table.setBorderWidth(1);
                table.setPadding(0);
                table.setSpacing(0);

                //添加表头的元素，并设置表头背景的颜色
                Color chade = new Color(176, 196, 222);

                Cell cell = new Cell("编号");
                addCell(table, cell, chade);
                cell = new Cell("字段名");
                addCell(table, cell, chade);
                cell = new Cell("类型");
                addCell(table, cell, chade);
                cell = new Cell("是否非空");
                addCell(table, cell, chade);
                cell = new Cell("是否主键");
                addCell(table, cell, chade);
                cell = new Cell("注释");
                addCell(table, cell, chade);

                table.endHeaders();

                // 表格的主体
                for (int k = 0; k < list.size(); k++) {
                    addContent(table, cell, (k + 1) + "");
                    addContent(table, cell,(String) list.get(k).get("Field"));
                    addContent(table, cell,(String) list.get(k).get("Type"));
                    addContent(table, cell,  list.get(k).get("Null").equals("YES") ? "否" : "是");
                    addContent(table, cell,  list.get(k).get("Key") != "" ? "是" : "否");
                    addContent(table, cell, (String) list.get(k).get("Comment"));
                }
                Paragraph pheae = new Paragraph(all);
                //写入表说明
                document.add(pheae);
                //生成表格
                document.add(table);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加表头到表格
     *
     * @param table
     * @param cell
     * @param chade
     */
    private void addCell(Table table, Cell cell, Color chade) {
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(chade);
        table.addCell(cell);
    }
    /**
     * 添加内容到表格
     *
     * @param table
     * @param content
     */
    private void addContent(Table table, Cell cell, String content) {
        cell = new Cell(content);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

}