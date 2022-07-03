package scasa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scasa.model.Admin;
import scasa.connection.ConnectionManager;

public class ConnectionManager {
	
	static Connection con;
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "SCASA";
	private static final String DB_PASSWORD = "system";
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DB_DRIVER);
			
			try {
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("connected");
			}
			
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
	return con;
	}

	  //........................ Admin Login Session ...................................//
	
	
  	public Admin login(String aemail, String apassword) throws SQLException {
  		ConnectionManager cm = new ConnectionManager();
  		Connection con = cm.getConnection();
  		
  		try {
  			String sql = "select * from ADMINS where AEMAIL=? and APASSWORD=?";
  			PreparedStatement ps = con.prepareStatement(sql);
  			
  			ps.setString(1, aemail);
  			ps.setString(2, apassword);
  			ps.executeQuery();
  			
  			ResultSet rs = ps.executeQuery();
  			
  			if(rs.next()) {	
  				Admin admin = new Admin();
  				admin.setAdminid	(rs.getInt("ADMINID"));	
  				admin.setApassword	(rs.getString("APASSWORD"));	
  				admin.setRole		(rs.getString("ROLE"));
  				admin.setAemail		(rs.getString("AEMAIL"));
  				admin.setAname		(rs.getString("ANAME"));
  				return admin;
  			}
  		}
  		catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}finally{
  			con.close();
  		}
  		return null;
  	}

	  //.......... Hardware Send Data Configuration (Temperature, RFID) .................//
	
  	

}
