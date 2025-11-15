package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestClass {
	public static void main(String[] args) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/masterdb?useSSL=false&serverTimezone=UTC",
                "root",
                "Sath26$@"
            );
            System.out.println("✅ Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
