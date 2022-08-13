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

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        //1.准备数据，利用Mybatis从数据库获取数据
        Brand brand = brandService.selectById(id);

        //2. 存储到request域中
        request.setAttribute("brand",brand);

        //3. 转发到 brands.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
