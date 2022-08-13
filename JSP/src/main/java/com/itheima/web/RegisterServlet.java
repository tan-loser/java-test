package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //表单中获取的验证码
        String checkCode = request.getParameter("checkCode");
        //session中获取的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //比对 忽略大小写比对，使用equalsIgnoreCase方法
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //不允许注册
            request.setAttribute("register_msg","验证码错误！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        //调用注册方法
        boolean flag = service.register(user);

        //判断注册是否成功
        if(flag){
            //注册成功
            request.setAttribute("register_msg","注册成功，请登录！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }else{
            //注册失败
            request.setAttribute("register_msg","用户名已存在！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);


        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
