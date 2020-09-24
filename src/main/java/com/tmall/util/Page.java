package com.tmall.util;

public class Page {

    //专门用来做分页
    private int strat; //每页的开始数
    private int count; //每页显示数
    private int total; //总数
    private String param; //要根据id查询的id提供参数

    private static final int defaultCount = 5; //默认每页显示5条

    public Page(){
        this.count = defaultCount;
    }
    //判断是否有前一页
    public boolean isHasPreviouse(){
        if(strat==0)
            return false;
        return true;
    }

    //判断是否有后一页
    public boolean isHasNext(){
        if(strat==getLast())
            return false;
        return true;
    }

    //计算出总共有几页
    public int getTotalPage(){
        int sta;
        //假设有50个数据则刚好10页
        if(total%count==0)
            sta = total / count;
        else
            sta = total / count + 1;
        //如果总数小于5，就默认为一页
        sta = total<count?1:sta;

        return sta;
    }

    //计算出最后一页的开始数
    public int getLast(){
        int num;
        //假设有50个数据则最后一页的开始数为50-5
        if(total%count==0)
            num = total - count;
        else
            num = total - total%count;
        //如果total小于count则最后一页的开始数为0
        num = total<count?0:num;
        return num;
    }

    public int getStrat() {
        return strat;
    }

    public void setStrat(int strat) {
        this.strat = strat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
