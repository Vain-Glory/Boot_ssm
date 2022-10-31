package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAllBrand();

    void add(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);
    void deleteById(int id);

    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);
    int selectTotalCount();

    List<Brand> selectByPageAndCondition(@Param("begin")int begin,@Param("size")int size,@Param("brand")Brand brand);
    int selectTotalCountByCondition(Brand brand);
}

