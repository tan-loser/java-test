package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

    //当对象被创建时加载
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源
        System.out.println("ContextLoaderListener...");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
