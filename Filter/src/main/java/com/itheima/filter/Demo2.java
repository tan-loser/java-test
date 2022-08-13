package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//拦截链 执行先后按照过滤器 类名  排序
/*
filterDemo1 放行获取资源前 被执行了 1
filterDemo2 放行获取资源前 被执行了2
访问资源3
filterDemo2 放行获取资源后 被执行了4
filterDemo1 放行获取资源后 被执行了5
*/
@WebFilter("/*")
public class Demo2 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行前对 request 数据进行处理
        System.out.println("filterDemo2 放行获取资源前 被执行了2");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        //放行后对 response 数据进行处理
        System.out.println("filterDemo2 放行获取资源后 被执行了4");
    }

    public void destroy() {

    }
}
