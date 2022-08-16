package com.itheima.brand.mapper;

import com.itheima.brand.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandMapper")
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 修改
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void update(Brand brand);
    /**
     * 通过 id 查询数据
     * @param id
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandMapper")
    Brand selectById(int id);

    /**
     * 通过id删除数据
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

}
