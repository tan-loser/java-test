package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 处理乱码  通过模板创建的 servlet
 *
 * post 可以通过设置流编码得到正确的结果
 * request.setCharacterEncoding("utf-8");
 *
 * tomcat8 之前 get请求 默认的字符编码为 ISO-8859-1 浏览器默认的字符编码为 utf-8，不处理会产生乱码
 * get 不是通过流的方式，需要通过 URL编码 URL解码解决
 * 编码:  java.net.URLEncoder.encode("需要被编码的内容","字符集(UTF-8)")
 * 解码:  java.net.URLDecoder.decode("需要被解码的内容","字符集(UTF-8)")
 */

@WebServlet("/req3")
public class req3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("user");
        System.out.println(request.getAttribute("msg"));
        System.out.println("req3~");

        //方法一
        //URL编码 编码成对应的二进制
        String encode = URLEncoder.encode(username, "ISO-8859-1");
        System.out.println(encode);
        //URL解码 用 utf-8 的格式解码
        String decode = URLDecoder.decode(encode, "utf-8");
        System.out.println(decode); //此处打印的是对应的数据
        System.out.println("--------------------------");

        //方法二
        System.out.println("解决乱码前："+username);
        username  = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        System.out.println("解决乱码后："+username);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post 处理编码不一致的问题
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("user");
        System.out.println(name);
    }
}
