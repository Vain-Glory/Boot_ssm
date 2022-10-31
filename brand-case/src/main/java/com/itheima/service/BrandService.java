package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;
/*
²éÑ¯ËùÓÐ
 */
public interface BrandService {
    List<Brand> selectAll();
    void add(Brand brand);
    void deleteByIds(int[] ids);
    void deleteById(int id);
    PageBean<Brand> selectPage(int currentPage,int pageSize);
    PageBean<Brand> selectPageAndCondition(int currentPage,int pageSize,Brand brand);
}
