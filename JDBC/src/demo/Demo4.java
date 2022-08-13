package demo;

import domain.Account;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
   通过工具类简化获取连接和关闭连接
 */
public class Demo4 {
    private static List<Account> list = null;
    private static Object Account;

    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from account";
        ResultSet rs = stmt.executeQuery(sql);

        Account account = null;
        List<Account> list = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString(2);
            double balance = rs.getDouble(3);

            account = new Account();
            account.setId(id);
            account.setName(name);
            account.setBalance(balance);

            System.out.println("================");
            System.out.println(account);

            list.add(account);

        }
        JDBCUtils.close(rs,stmt,conn);
    }
}
