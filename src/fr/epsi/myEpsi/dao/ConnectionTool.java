package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = ConnectionTool.getConnection();
		if(con != null){
			System.out.println(con.toString());
			try{
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
			return con;
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
