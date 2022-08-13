package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//配置拦截资源的路径 1./* 2.index.jsp 3.user/* 4.*.jsp
@WebFilter("/*")
public class Demo1 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行前对 request 数据进行处理
        System.out.println("filterDemo1 放行获取资源前 被执行了1");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        //放行后对 response 数据进行处理
        System.out.println("filterDemo1 放行获取资源后 被执行了5");
    }

    public void destroy() {

    }
}
