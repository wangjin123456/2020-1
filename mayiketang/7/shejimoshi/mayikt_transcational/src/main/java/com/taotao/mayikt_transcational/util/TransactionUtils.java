package com.taotao.mayikt_transcational.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 *@author tom
 *Date  2020/5/28 0028 9:03
 *
 */
@Component
public class TransactionUtils {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * begin 开启事务
     * @return
     */
    public TransactionStatus begin(){
        TransactionStatus transactionStatus=dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return  transactionStatus;
    }

    /**
     * 提交事务
     * @param transaction
     */
    public  void commit(TransactionStatus transaction){
        dataSourceTransactionManager.commit(transaction);
    }

    /**
     * 回滚事务
     * @param transaction
     */
    public  void rollback(TransactionStatus transaction){
        dataSourceTransactionManager.rollback(transaction);
    }
}
