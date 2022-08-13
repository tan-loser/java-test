package com.itheima.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据
 */
@WebServlet("/resp2")
public class resp2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp2~");

        //设置响应的是 html 需要返回中文，字符编码为utf-8
        response.setContentType("text/html;charset=utf-8");
//        response.setHeader("content-type","text/html");

        //获取字符输出流
        PrintWriter w = response.getWriter();
        w.write("<h1>aaa</h1>");
        w.write("<h1>你好</h1>");
        //一次请求响应结束后，response对象就会被销毁掉，所以不要手动关闭流。

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
