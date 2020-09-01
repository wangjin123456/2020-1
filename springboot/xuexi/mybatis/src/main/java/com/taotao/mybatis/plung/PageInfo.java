package com.taotao.mybatis.plung;

import java.io.Serializable;

/**
 * @author tom
 * @date 2020/4/3 0003 15:38
 */
public class PageInfo implements Serializable {
    private  static  final  long serialVersionUID =1L;
    private  int totalNumber;//当前表中总的数据
    private  int currentPage; //当前页的位置
    private int totalPage;//总页数
    private int pageSize;//页面大小
    private int startIndex;//检索的起始位置
    private  int totalSelect;//检索的总条目



    public int getTotalNumber() {
        return totalNumber;
    }

    public PageInfo setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PageInfo setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public PageInfo setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageInfo setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public PageInfo setStartIndex(int startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public int getTotalSelect() {
        return totalSelect;
    }

    public PageInfo setTotalSelect(int totalSelect) {
        this.totalSelect = totalSelect;
        return this;
    }

    //计算
    public  void count(){
        int totalPageTemp =this.totalNumber / this.pageSize;
        int plus=(this.totalNumber % this.pageSize)== 0 ?0: 1;
        totalPageTemp= totalPageTemp + plus;
        if(totalPageTemp <=0){
            totalPageTemp=1;
        }
        this.totalPage =totalPageTemp;//总页数
        if(this.totalPage < this.currentPage){
            this.currentPage=this.totalPage;
        }
        if(this.currentPage <1){
            this.currentPage=1;
        }
        this.startIndex=(this.currentPage -1) * this.pageSize;//
        this.totalSelect =this.pageSize; //检索数量等于页面大小
    }
}
