package demo;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
   事务操作
 */
public class Demo5 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            String sql1 = "update account set balance = balance+? where id = ?";
            String sql2 = "update account set balance = balance-? where id = ?";

            stmt1 = conn.prepareStatement(sql1);
            stmt2 = conn.prepareStatement(sql2);

            stmt1.setInt(1,100);
            stmt1.setInt(2,1);

            stmt2.setInt(1,100);
            stmt2.setInt(2,2);

            stmt1.executeUpdate();
            //手动创建错误
//            int i = 3/0;
            stmt2.executeUpdate();

            //提交事务
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            //事务回滚
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JDBCUtils.close(stmt1,conn);
            JDBCUtils.close(stmt2,null);
        }

    }

}
