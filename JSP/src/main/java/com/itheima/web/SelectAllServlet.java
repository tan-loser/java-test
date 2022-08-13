package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * MVC模式                        Model         <-->        Controller -> View
 *                              /      \                      |
 * 演示三层架构 （数据访问层dao/mapper 业务逻辑层service 表象层web/controller）
 *
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.准备数据，利用Mybatis从数据库获取数据
        List<Brand> brands = brandService.selectAll();

        //2. 存储到request域中
        request.setAttribute("brands",brands);

        //3. 请求转发到 brands.jsp
        request.getRequestDispatcher("brands.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
