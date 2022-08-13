package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 解决get post通过不同的方式获得请求参数
 * 获取参数的不同方法
 *
 * 在获取get post请求参数时
 * get req.getQueryString()
 * post req.getReader().readLine()
 * 采用以下方法 ，不用使用不同的方法
 *  获取所有参数Map集合
 *    Map<String,String[]> getParameterMap()
 *  根据名称获取参数值（数组）
 *    String[] getParameterValues(String name)
 *  根据名称获取参数值(单个值)
 *    String getParameter(String name)
 */

@WebServlet("/req2")
public class req2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("get...");
        //请求所有数据 Map
        Map<String,String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + " : ");
            String[] value = map.get(key);
            for (String s : value) {
                System.out.print(s + " ");
            }
            System.out.println();

        }
        System.out.println("---------------------------");
        //请求的数据是数组
        String[] hobbys = req.getParameterValues("hobby");
        for (String hobby : hobbys) {
            System.out.println(hobby + " ");
        }

        System.out.println("---------------------------");
        //请求的数据是单个值
        String name = req.getParameter("user");
        System.out.println(name);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");

        //调用 doGet 方法,减少重复代码
        this.doGet(req,resp);

        /*//请求所有数据 Map
        Map<String,String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + " : ");
            String[] value = map.get(key);
            for (String s : value) {
                System.out.print(s + " ");
            }
            System.out.println();

        }
        System.out.println("---------------------------");
        //请求的数据是数组
        String[] hobbys = req.getParameterValues("hobby");
        for (String hobby : hobbys) {
            System.out.println(hobby + " ");
        }

        System.out.println("---------------------------");
        //请求的数据是单个值
        String name = req.getParameter("user");
        System.out.println(name);*/
    }
}
