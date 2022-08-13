package com.itheima.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 响应字节数据
 */
@WebServlet("/resp3")
public class resp3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp3~");

        //读取文件
        FileInputStream fis = new FileInputStream("C://Users//Lenovo//Pictures//Screenshots//屏幕截图(1).png");
        //获取字节输出流
        ServletOutputStream os = response.getOutputStream();

        //复制数据
        /*byte[] buffer  = new byte[1024];
        int len = 0;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }*/

        //使用工具简化数据复制
        //1.pom.xml 中添加依赖
        /*<dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.6</version>
        </dependency>*/
        //2.使用工具类
        IOUtils.copy(fis,os);

        fis.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
