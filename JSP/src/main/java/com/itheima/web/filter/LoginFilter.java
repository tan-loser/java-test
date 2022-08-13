package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        //判断访问的资源是否与登录注册相关
        String[] urls ={"/login.jsp","/imgs/","/css/","/LoginServlet","/register.jsp","/RegisterServlet","/CheckCodeServlet"};
        //获取当前资源访问路径
        String url = request.getRequestURL().toString();
        for (String s : urls) {
            if(url.contains(s)){
                //找到了，放行
                chain.doFilter(request,resp);
                //结束方法
                return;
            }
        }

        //判断session中是否有user
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        //判断user是否为null
        if(user != null){

            //放行
            chain.doFilter(req, resp);

        }else{
            //没有登录 跳转到相应页面 存储错误信息
            request.setAttribute("Login_msg","你尚未登录");
            request.getRequestDispatcher("/login.jsp").forward(request,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
