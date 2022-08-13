package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //查询所有
    List<Brand> selectAll();
    //通过id查询
    Brand selectById(int id);
    /*
       条件查询
       1.散装参数
       2.对象参数
       3.map集合参数
     */
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);
    //单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);
    //添加
    void add(Brand brand);

    //修改
    int update(Brand brand);

    //根据id删除
    void deleteById(int id);
    //批量删除
    void deleteByIds(@Param("ids") int[] ids);
}
