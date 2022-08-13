package com.itheima.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 正常关闭再开启服务器，session数据不会丢失
 * session钝化 将session数据保存到硬盘
 * session活化 将数据加载到session中
 * 正常开启 在命令行中输入 ---cd cookie ---- mvn tomcat7:run
 * 正常结束 ctrl + c
 */
@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username","张三");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
