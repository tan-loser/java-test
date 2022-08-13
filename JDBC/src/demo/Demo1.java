package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 JDBC快速入门
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{

        //1. 导入驱动jar包
        //2.注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        //3.获取数据库连接对象
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","123456");

        //4.定义sql语句
//        String sql = "update account set balance = 2000 where id = 1";
        String sql = "update account set balance = 2000";

        //5.获取执行sql的对象 Statement
        Statement stmt1 = conn1.createStatement();

        //6.执行sql
        int count1 = stmt1.executeUpdate(sql);

        //7.处理结果
        System.out.println(count1);

        //8.释放资源
        stmt1.close();
        conn1.close();


    }
}
