package MainProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Library4 {
	static Connection conn;

	public static Connection createConnection() {
		// Creating connection with database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mysql";
			String user = "root";
			String pass = "P@ssw0rd";

			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successfull");
			return conn;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;

	}

}
