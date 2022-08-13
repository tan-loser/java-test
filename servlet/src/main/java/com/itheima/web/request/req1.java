package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取请求数据
 */
@WebServlet("/req1")
public class req1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletRequest 和 HttpServletRequest 都是接口，实现类是 RequestFacade
        System.out.println(req);

        //1.获取请求行数据
        //获得请求方法  GET
        System.out.println(req.getMethod());
        //获得虚拟目录（项目访问路径）  /servlet
        System.out.println(req.getContextPath());
        //URL  http://localhost:8080/servlet/req1
        System.out.println(req.getRequestURL());
        //URI  /servlet/req1
        System.out.println(req.getRequestURI());
        //获得 GET方法 的请求参数
        System.out.println(req.getQueryString());  //username=zhangsan&password=1234  null

        System.out.println("-----------------------");
        //2.获取请求头数据  键：值 形式
        System.out.println(req.getHeader("user-agent"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------");
        //3.获取请求体 get没有请求体 post有请求体 使用form 表单
        //文本可以用 getReader 字节流可以用 getInputStream
        BufferedReader reader = req.getReader();
        System.out.println(reader.readLine());  //user=1&password=1
        System.out.println(reader.readLine());  //null
    }
}
