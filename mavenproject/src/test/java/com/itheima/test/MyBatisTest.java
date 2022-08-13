package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //传入参数id
        int id = 1;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //4. 释放资源
        sqlSession.close();
    }

    /**
     * 多条件查询
     * @throws IOException
     */
    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //方式一 ：接口方法参数使用 @Param 方式调用的方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        List<Brand> brands = brandMapper.selectByCondition(brand);

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        Map map = new HashMap();
//        map.put("status" , status);
//        map.put("companyName", companyName);
//        map.put("brandName" , brandName);
//        List<Brand> brands = brandMapper.selectByCondition(map);

        System.out.println(brands);

        //4. 释放资源
        sqlSession.close();
    }


    /**
     * 单条件查询
     * @throws IOException
     */
    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //方式一 ：接口方法参数使用 @Param 方式调用的方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        Map map = new HashMap();
//        map.put("status" , status);
//        map.put("companyName", companyName);
//        map.put("brandName" , brandName);
//        List<Brand> brands = brandMapper.selectByCondition(map);

        System.out.println(brands);

        //4. 释放资源
        sqlSession.close();
    }

    //添加
//    添加需要手动提交 commit
//      * 在最后使用 sqlSession.commit();
//      * sqlSessionFactory.openSession(true); 设置为自动提交
//
//
    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int orderd = 100;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //true 自动提交 false 手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //方式一 ：接口方法参数使用 @Param 方式调用的方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(orderd);

        brandMapper.add(brand);

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
//        Map map = new HashMap();
//        map.put("status" , status);
//        map.put("companyName", companyName);
//        map.put("brandName" , brandName);
//        List<Brand> brands = brandMapper.selectByCondition(map);

//        System.out.println(brands);

        //由于自动开启了事务 需要提交事务
        //也可在获得sqlSession对象时 添加参数，设置自动提交
//        sqlSession.commit();

        //4. 释放资源
        sqlSession.close();
    }
    //在相关的 xml 文件位置中配置 useGeneratedKeys keyProperty 这两个属性绑定返回 主键值 到 id 上
    @Test
    public void testAdd2() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int orderd = 100;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //true 自动提交 false 手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(orderd);

        brandMapper.add(brand);
        //由于自动开启了事务 需要提交事务
        //也可在获得sqlSession对象时 添加参数，设置自动提交
//        sqlSession.commit();

        //获取不到 id 的值，需要在xml文件相应的位置设置
        System.out.println(brand.getId());

        //4. 释放资源
        sqlSession.close();
    }

    /**
     * 修改
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int orderd = 110;
        int id = 5;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //true 自动提交 false 手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
        brand.setOrdered(orderd);
        brand.setId(id);

        int update = brandMapper.update(brand);
        System.out.println(update);
        //由于自动开启了事务 需要提交事务
        //也可在获得sqlSession对象时 添加参数，设置自动提交
//        sqlSession.commit();

        //4. 释放资源
        sqlSession.close();
    }

    /**
     * 根据用户id删除数据
     * @throws IOException
     */
    @Test
    public void testdeleteById() throws IOException {
        //接收参数
        int id = 5;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
        //true 自动提交 false 手动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        //4. 释放资源
        sqlSession.close();
    }
    /**
     * 根据用户id 批量 删除数据
     * @throws IOException
     */
    @Test
    public void testdeleteByIds() throws IOException {
        //接收参数
        int[] ids = {6,7,8};

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
        //true 自动提交 false 手动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        //4. 释放资源
        sqlSession.close();
    }

}
