package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBWapper {

	private static String url = "jdbc:mysql://localhost:3306/masterdb";
	private static String name = "root";
	private static String password = "Sath26$@";
	
	public static Connection getConnection() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,name,password);
			return con;
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error while connect the db"+e.getMessage());
		}
		return null;
	}
}
