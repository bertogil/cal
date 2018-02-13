package com.berto.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JtdsSqlExpressInstanceConnect {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		String url = "jdbc:jtds:sqlserver://10.221.36.33;DatabaseName=master";
		String driver = "net.sourceforge.jtds.jdbc.Driver";
		String userName = "sa";
		String password = "mt";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Conectando a la base de datos");
			DatabaseMetaData dbm = conn.getMetaData();
			rs = dbm.getTables(null, null, "%", new String[] { "TABLE" });
			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			rs.close();
		}
	}
}