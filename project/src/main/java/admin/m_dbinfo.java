package admin;

import java.sql.Connection;
import java.sql.DriverManager;

// 데이터베이스

public class m_dbinfo {
	public static Connection getConnection() throws Exception{
		String db_driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://kbsn.or.kr:3306/chang_e";
		String db_user = "chang_e";
		String db_passwd = "echang2025";
		
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url, db_user, db_passwd);
		
		return con;
	}
}