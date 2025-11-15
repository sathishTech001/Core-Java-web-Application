package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBWapper {

	private static String url = "jdbc:mysql://localhost:3306/masterdb?useSSL=false&serverTimezone=UTC";
	private static String name = "root";
	private static String password = "Sath26$@";

	public static Connection getConnection() throws ClassNotFoundException {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(url,name,password);
//			return con;
//		}catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("error while connect the db"+e.getMessage());
//		}
//		return null;
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/masterdb?useSSL=false&serverTimezone=UTC",
                "root",
                "Sath26$@"
            );
            System.out.println("✅ Connection successful!");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
}
