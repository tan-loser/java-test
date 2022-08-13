package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @ResultMap("brandMapper")
    @Select("select * from tb_brand")
    List<Brand> selectAll();

    /**
     * 添加
     * @param brand
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 通过 id 查询
     */
    @ResultMap("brandMapper")
    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(int id);

    /**
     * 修改
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void update(Brand brand);

    /**
     * 删除
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

}
