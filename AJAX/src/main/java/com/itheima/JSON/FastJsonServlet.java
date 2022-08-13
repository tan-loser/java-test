package com.itheima.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/fastJsonServlet")
public class FastJsonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getParameter()不能接受JSON数据

        //post方法 获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        User user = JSON.parseObject(s, User.class);
        System.out.println(user);

        User user1 = new User();
        user1.setName("张三");
        user1.setAddr("上海");
        user1.setAge(19);

        User user2 = new User();
        user2.setName("张四");
        user2.setAddr("上海");
        user2.setAge(19);

        User[] users = {user1,user2};


        String jsonString = JSON.toJSONString(users);
        //响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
