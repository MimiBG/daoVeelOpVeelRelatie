package daoVeelOpVeelRelatie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	private static final String DB_URL = "jdbc:oracle:thin:MIMI@//localhost:8088/xe";
	private static final String DB_USER = "MIMI";
	private static final String DB_PASS = "Albena-66";
	
	protected static Connection conn;
	
	protected Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		return conn;
	}
	
	public void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}