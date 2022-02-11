package applicant.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	// 수정하라고 하셨음************************************************************
	private static DataSource ds;

	static {
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
			System.out.println("oracle됐어");

		}catch(NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		System.out.println("connection됐어");
		return ds.getConnection();
	}
	

	// DML용
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// SELECT용
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}
