package com.itheima.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置响应数据  请求重定向
 *
 */
@WebServlet("/resp1")
public class resp1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//设置响应状态码
        response.setStatus(302);
        //设置响应头键值对
        response.setHeader("Content-type","text/html");
        //响应体 获取输出流 还有字符输出流 getWriter()
        ServletOutputStream os = response.getOutputStream();*/

        System.out.println("resp1~");

        //重定向 状态码302 Location参数
//        response.setStatus(302);
//        response.setHeader("Location","/servlet/resp2");
        //简化方法  由于tomcat可以配置项目的虚拟目录，可能导致配置不一样
        //可以通过 动态获取虚拟目录 解决
        response.sendRedirect(request.getContextPath() + "/resp2");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
