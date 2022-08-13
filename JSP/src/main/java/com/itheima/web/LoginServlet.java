package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = service.login(username, password);
        if(user != null){
            //判断用户是否选择记住我
            if("1".equals(remember)){
                //发送cookie
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                response.addCookie(c_username);
                response.addCookie(c_password);

            }

            //登录成功后吧用户对象存储在session对象中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            //登录成功 跳转到selectAllServlet
            String contextPath = request.getContextPath();
            //重定向
            //由于是重定向，是浏览器重新发送请求，只有session中的数据可以在下个页面使用
            response.sendRedirect(contextPath + "/selectAllServlet");
        }else{
            //登录失败

            //存储错误信息到request
            request.setAttribute("Login_msg","用户或密码错误");
            //跳转到login.jsp中
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
