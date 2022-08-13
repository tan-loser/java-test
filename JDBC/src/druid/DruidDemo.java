package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
    使用 数据库连接池 连接数据库
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包 druid-1.1.12.jar
        //2.定义配置文件 druid.properties
        //3.加载配置文件
        Properties pro = new Properties();
        pro.load(new FileInputStream("D:\\桌面文件\\java基础\\test\\JDBC\\src\\druid.properties"));;
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from account";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double balance = rs.getDouble(3);

            System.out.println(id + "-" + name + "-" + balance);
        }

        rs.close();
        stmt.close();
        conn.close();

    }
}
