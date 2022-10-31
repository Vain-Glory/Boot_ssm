package com.itheima.pojo;

import java.util.List;

public class PageBean<T> {
    private int totalCount;
    private List<T> rows;

    public PageBean() {
    }

    public PageBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    /**
     * ��ȡ
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * ����
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * ��ȡ
     * @return rows
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * ����
     * @param rows
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String toString() {
        return "PageBean{totalCount = " + totalCount + ", rows = " + rows + "}";
    }
}
