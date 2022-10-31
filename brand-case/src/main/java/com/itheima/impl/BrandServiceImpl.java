package com.itheima.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<Brand> selectAll() {
        SqlSession session=factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAllBrand();
        session.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession session=factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        mapper.add(brand);
        session.commit();
        session.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession session=factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        session.commit();
        session.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSession session=factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        session.commit();
        session.close();
    }

    @Override
    public PageBean<Brand> selectPage(int currentPage, int pageSize) {
        SqlSession session=factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        int begin=(currentPage-1)*pageSize;
        List<Brand> rows = mapper.selectByPage(begin, pageSize);
        int totalCount = mapper.selectTotalCount();
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        session.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession session=factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        int begin=(currentPage-1)*pageSize;

        String brandName = brand.getBrandName();
        if (brandName!=null && brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (brandName!=null && companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }
        //System.out.println("brandName:"+brand.getBrandName());
       // System.out.println("companyName:"+brand.getCompanyName());
        List<Brand> rows = mapper.selectByPageAndCondition(begin,pageSize,brand);
        int totalCount = mapper.selectTotalCountByCondition(brand);
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        session.close();
        return pageBean;
    }
}
