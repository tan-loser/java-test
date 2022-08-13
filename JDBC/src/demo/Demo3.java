package demo;

import java.sql.*;

/**
 防止SQL注入，使用preparedStatement
 */
public class Demo3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","123456");
            String sql = "select * from account where name = ? and balance = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"zhangsan");
            pstmt.setInt(2,222);
            rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("id"));
            }else{
                System.out.println("不存在");
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt != null){
                try {
                    pstmt.close();
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
