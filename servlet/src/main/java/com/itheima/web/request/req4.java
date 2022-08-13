package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 * 一种在服务器内部的资源跳转方式
 * req.getRequestDispatcher("资源B路径").forward(req,resp);
 *
 * 转发中如何传递共享数据
 * 存储数据到request域[范围,数据是存储在request对象]中
 *      void setAttribute(String name,Object o);
 * 根据key获取值
 *      Object getAttribute(String name);
 * 根据key删除该键值对
 *      void removeAttribute(String name);
 *
 */
@WebServlet("/req4")
public class req4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("req4~");
        //设置共享数据
        request.setAttribute("msg","hello");
        //请求转发
        request.getRequestDispatcher("/req3").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
