package project;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Connection_DB {
	static private Connection con;
	public static Connection main() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shs";
		con = (Connection)DriverManager.getConnection(url, "root", "admin");
		
	}
		catch(Exception e) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		return con;
	}}
