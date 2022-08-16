package com.itheima.brand.service;

import com.itheima.brand.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改数据
     * @param brand
     */
    void update(Brand brand);
    /**
     * 通过 id 查询数据
     * @param id
     */
    Brand selectById(int id);

    /**
     * 通过id删除数据
     * @param id
     */
    void deleteById(int id);
}
