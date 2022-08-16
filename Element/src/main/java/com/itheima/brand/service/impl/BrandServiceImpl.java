package com.itheima.brand.service.impl;

import com.itheima.brand.mapper.BrandMapper;
import com.itheima.brand.pojo.Brand;
import com.itheima.brand.service.BrandService;
import com.itheima.brand.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    //1.创建sqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        List<Brand> brands = mapper.selectAll();

        //释放资源
        sqlSession.close();

        return brands;
    }

    public void add(Brand brand) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.add(brand);
        sqlSession.commit(); //提交事务

        //释放资源
        sqlSession.close();

    }

    public void update(Brand brand) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.update(brand);
        sqlSession.commit(); //提交事务

        //释放资源
        sqlSession.close();

    }

    public Brand selectById(int id) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        Brand brand = mapper.selectById(id);

        //释放资源
        sqlSession.close();

        return brand;
    }

    public void deleteById(int id) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.deleteById(id);
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
