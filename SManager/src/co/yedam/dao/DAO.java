package co.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
	 * DB connection 기능
	 */
public class DAO {
	 Connection conn = null;
	 Statement stmt;
	 PreparedStatement psmt;
	 ResultSet rs;
	// 커넥션
		public Connection getConn() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			String user = "jsp";
			String pass = "jsp";
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, pass);
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("오라클 드라이버 없음.");
				e.printStackTrace();
				return null;
			}
			return conn;
		}
}
