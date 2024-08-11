package ConnectionModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {
	static String user = "root";
	static String password = "Pass";
	static String className = "com.mysql.cj.jdbc.Driver";
	static String constr = "jdbc:mysql://localhost:3306/projectdb";
	
	public static Connection getDbConnection () throws ClassNotFoundException, SQLException {
		Class.forName(className);
		Connection connection = DriverManager.getConnection(constr,user,password);
		System.out.println("Connection Succeed");
		return connection;
	}
}
