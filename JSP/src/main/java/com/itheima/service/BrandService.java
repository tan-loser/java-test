package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService{

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }
    /**
     * 通过 id 查询
     * @return
     */
    public Brand selectById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }

    /**
     * 修改
     * @param brand
     */
    public void update(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    public void deleteById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
}
