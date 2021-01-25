package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	private final String url = "jdbc:postgresql://localhost/pwd";
	private final String user = "ypz";
	private final String password = "pass";
	protected Connection conn = null;

	public Connection connect() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			if(conn != null){
				System.out.println("Connected to db PWD");
			}else {
				System.out.println("Fail to cannect with PWD db");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
}
	

