package com.itheima.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * cookie最大存储3KB session没限制
 * 具体例子在用于改进 JSP模块
 */
@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String value = "zs";

        //传输中文需要进行url编码
        String value = "张三";
        //URL编码
        value = URLEncoder.encode(value,"utf-8");
        Cookie cookie = new Cookie("username",value);

        //设置存活时间   ，1周 7天
        //正数 单位秒 表示存活多少时间，关闭浏览器也能+
        //负数 默认值 浏览器一关，内存释放，cookie消失
        //零  表示删除对应的cookie
//        cookie.setMaxAge(60*60*24*7);
        cookie.setMaxAge(0);

        //发送cookie
        response.addCookie(cookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
