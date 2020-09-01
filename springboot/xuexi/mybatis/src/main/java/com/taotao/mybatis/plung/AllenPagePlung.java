package com.taotao.mybatis.plung;


import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/**
 * 分页插件
 * @author tom
 * @date 2020/4/3 0003 14:36
 */
@Intercepts({@Signature(
        type= StatementHandler.class,
        method ="prepare",
        args = {Connection.class,Integer.class}
)})
@Component
public class AllenPagePlung implements Interceptor {
    //插件核心业务
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        /**
         * 1,拿到原始的sql语句
         * 2，修改原始的sql语句，增加分页 select * from user  limit 0,3
         * 3,执行jdbc 去查询总数
         */
        StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
           //拿到原始sql语句
        BoundSql boundSql=statementHandler.getBoundSql();
        String sql=boundSql.getSql();
        System.out.println("原始sql："+sql);
        //分页参数获取
        Object paramObj=boundSql.getParameterObject();
        //statementHandler 转换成 metaObject
        MetaObject metaObject= SystemMetaObject.forObject(statementHandler);
        //上下文 spring context.getBean("userbean")
        MappedStatement mappedStatement=(MappedStatement)metaObject.getValue("delegate.mappedStatement");
        //读取mapper 接口中的方法名称 selectUserByPage
        String mapperMethodName =mappedStatement.getId();
        //以ByPage 结尾的做分页操作
         if(mapperMethodName.matches(".*ByPage$")){
             Map<String,Object> params=(Map<String,Object>)paramObj;
              PageInfo pageInfo=(PageInfo)params.get("page");
              //select * from  user
              String countSql="select count(0) from ("+sql +") a";
             System.out.println("查询总数的sql：" + countSql);
              //执行jdbc 操作
             Connection connection=(Connection)invocation.getArgs()[0];
             PreparedStatement  countStatement=connection.prepareStatement(countSql);
             ParameterHandler parameterHandler=(ParameterHandler)metaObject.getValue("delegate.parameterHandler");
              parameterHandler.setParameters(countStatement);
             ResultSet rs=countStatement.executeQuery();
             if(rs.next()){
                 pageInfo.setTotalNumber(rs.getInt(1));
             }
             rs.close();
             countStatement.close();
            //改造sql  limit
             String pageSql= this.generatePageSql(sql, pageInfo);
             System.out.println("分页："+pageSql);
             metaObject.setValue("delegate.boundSql.sql",pageSql);

         }
         //把执行流程交给 mybatis
        return invocation.proceed();
    }
     //把自定义的插件加入到mybatis中
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }


    //设置属性
    @Override
    public void setProperties(Properties properties) {

    }


    //根据原始sql  生成limit sql
    public String generatePageSql(String sql, PageInfo pageInfo){
        StringBuilder sb=new StringBuilder();
        sb.append(sql);
        sb.append(" limit " + pageInfo.getCurrentPage()+ ","+ pageInfo.getPageSize());
        return  sb.toString();

    }
}
