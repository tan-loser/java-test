package util;


import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    //通过静态代码获取配置文件中数据
    static{
        try{
            //1.创建Properties集合
            Properties pro  = new Properties();
            ClassLoader classLoder = JDBCUtils.class.getClassLoader();
            URL res = classLoder.getResource("jdbc.properties");
//            String path = res.getPath();
            String path = "D:\\桌面文件\\java基础\\test\\JDBC\\src\\jdbc.properties";
            //2.加载文件
            pro.load(new FileReader(path));
            //3.获取数据、赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            System.out.println(url + user + password + driver);
            Class.forName(driver);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 获取JDBC连接
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放Statement Connection资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放ResultSet Statement Connection资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
