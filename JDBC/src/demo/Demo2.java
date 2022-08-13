package demo;

import java.sql.*;

/**
 ressultSet 使用SQL查询数据
 */
public class Demo2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","123456");
            String sql = "select *  from account";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double balance = rs.getDouble(3);
                System.out.println(id + "---" + name + "---" + balance);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
