package util;

import java.sql.*;

public class DBConnectionUtil extends CommonUtil {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
	//	Connection connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),properties.getProperty(CommonConstants.UN),properties.getProperty(CommonConstants.PWD));
		
		Connection connection = DriverManager.getConnection(CommonConstants.URL,CommonConstants.UN,CommonConstants.PWD);
		
		return connection;
	}
	
}
