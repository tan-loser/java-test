package com.itheima.brand.web.old;

import com.alibaba.fastjson.JSON;
import com.itheima.brand.pojo.Brand;
import com.itheima.brand.service.BrandService;
import com.itheima.brand.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受品牌数据
        BufferedReader reader = request.getReader();
        String str = reader.readLine(); //json 字符串

        //转换成Brand对象
        Brand brand = JSON.parseObject(str, Brand.class);

        //调用service添加数据
        brandService.add(brand);

        //响应成功的标志
        response.getWriter().write("success");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
