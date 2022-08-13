package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param userName
     * @param passWord
     * @return
     */
    public User login(String userName,String passWord){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(userName, passWord);

        sqlSession.close();
        return user;
    }/**
     * 注册方法
     * @param user
     * @return
     */
    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //判断用户是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if(u == null){
            //用户不存在
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;

    }

}
