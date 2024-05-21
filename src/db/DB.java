package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				Properties props = DB.getProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			return conn;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	public static void closeStatement(Statement st) {
		try {
			st.close();
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	private static Properties getProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties");) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

}
