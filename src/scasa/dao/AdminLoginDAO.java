package scasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;


import scasa.connection.ConnectionManager;
import scasa.model.Admin;

public class AdminLoginDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps= null;
	static Statement stmt= null;
	static int adminid, hodid;
	static String role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, apassword ;

	public static Admin getAdmin(Admin admin) {
		adminid = admin.getAdminid();
		
		String searchQuery = "select * from admins where adminid='" + adminid + "'";     
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if Admin exists set the isValid variable to true
            if (more) {
                admin.setValid(true);
           	}
           
            else if (!more) {
            	admin.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return admin;
	}
	
	public void add(Admin admin) {
		
//        adminid	 	= admin.getAdminid();
//        hodid  		= admin.getHodid();
//        role	 	= admin.getRole();
//        aname     	= admin.getAname();
//        agender     = admin.getAgender();
//        anotel		= admin.getAnotel();
//        aemail    	= admin.getAemail();
//        adepartment = admin.getAdepartment();
//        aposition  	= admin.getAposition();
//        anric 		= admin.getAnric();  
//        arfid 		= admin.getArfid();      
//        astatus 	= admin.getAstatus();
//        astartdate 	= admin.getAstartdate();
//        apassword 	= admin.getApassword();
        
    	try {
    		
    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date date = sdf1.parse(admin.getAstartdate());
    		java.sql.Date sqlAstartDate = new java.sql.Date(date.getTime());
    		
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into admins (adminid, hodid, role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, apassword)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		ps.setInt	(1,admin.getAdminid());
    		ps.setInt	(2,admin.getHodid());
    		ps.setString(3,admin.getRole());
    		ps.setString(4,admin.getAname());
    		ps.setString(5,admin.getAgender());
    		ps.setString(6,admin.getAnotel());
    		ps.setString(7,admin.getAemail());
    		ps.setString(8,admin.getAdepartment());
    		ps.setString(9,admin.getAposition());
    		ps.setString(10,admin.getAnric());
    		ps.setString(11,admin.getArfid());
    		ps.setString(12,admin.getAstatus());
    		ps.setDate  (13,sqlAstartDate);
    		ps.setString(14,admin.getApassword());
    		ps.executeUpdate();
            
    	}

    	catch (Exception ex) {
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentCon != null) {
    			try {
    				currentCon.close();
    			} catch (Exception e) {
    			}
    			currentCon = null;
    		}
    	}
		
		
	}
	
	public List<Admin> getAllAdmin() {
		List<Admin> admins = new ArrayList<Admin>();
		  
		  try {
			  
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			  
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from admins where role = 'admins' order by aemail";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Admin admin = new Admin();
		          admin.setAdminid		(rs.getInt	("adminid"));
		          admin.setHodid		(rs.getInt	("hodid"));
		          admin.setRole			(rs.getString("role"));
		          admin.setAname		(rs.getString("aname"));
		          admin.setAgender		(rs.getString("agender"));
		          admin.setAnotel		(rs.getString("anotel"));
		          admin.setAemail		(rs.getString("aemail"));
		          admin.setAdepartment	(rs.getString("adepartment"));
		          admin.setAposition	(rs.getString("aposition"));
		          admin.setAnric		(rs.getString("anric"));
		          admin.setArfid		(rs.getString("arfid"));
		          admin.setAstatus		(rs.getString("astatus"));
		         		          
		          java.util.Date date = sdf1.parse(rs.getString("astartdate"));
		          admin.setAstartdate	(sdf1.format(date));
		          
		          admin.setApassword	(rs.getString("apassword"));
		          
		          admins.add(admin);
		      }
		  } catch (SQLException | ParseException e) {
		      e.printStackTrace();
		  }

		  return admins;
	}
	
	public void deleteAdmin(int adminid) {
		try {
	    	currentCon = ConnectionManager.getConnection();
	    	ps=currentCon.prepareStatement("delete from admins where adminid=?");
	        ps.setInt(1, adminid);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public Admin getAdminById(String aemail) {
		Admin admin = new Admin();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from admins where adminid=?");
	        
	        ps.setInt (1, adminid);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
		          admin.setAdminid		(rs.getInt	 ("adminid"));
		          admin.setHodid		(rs.getInt	 ("hodid"));
		          admin.setRole			(rs.getString("role"));
		          admin.setAname		(rs.getString("aname"));
		          admin.setAgender		(rs.getString("agender"));
		          admin.setAnotel		(rs.getString("anotel"));
		          admin.setAemail		(rs.getString("aemail"));
		          admin.setAdepartment	(rs.getString("adepartment"));
		          admin.setAposition	(rs.getString("aposition"));
		          admin.setAnric		(rs.getString("anric"));
		          admin.setArfid		(rs.getString("arfid"));
		          admin.setAstatus		(rs.getString("astatus"));
		          admin.setAstartdate	(rs.getString("astartdate"));
		          admin.setApassword	(rs.getString("apassword"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	    return admin;
	}

	public void updateAdmin(Admin admin) {
		
//        adminid	 	= admin.getAdminid();
//        hodid	  	= admin.getHodid();
//        role	 	= admin.getRole();
//        aname     	= admin.getAname();
//        agender     = admin.getAgender();
//        anotel    	= admin.getAnotel();
//        aemail    	= admin.getAemail();
//        adepartment = admin.getAdepartment();
//        aposition  	= admin.getAposition();
//        anric 		= admin.getAnric();
//        arfid 		= admin.getArfid();
//        astatus 	= admin.getAstatus();
//        astartdate 	= admin.getAstartdate();
//        apassword 	= admin.getApassword();
		
		try {
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date date = sdf1.parse(admin.getAstartdate());
    		java.sql.Date sqlAstartDate = new java.sql.Date(date.getTime());
	
	        currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("update admins SET adminid=?, hodid=?, role=?, aname=?, agender=? anotel=?, aemail=?, adepartment=?, aposition=?, arfid=?, astatus=?, astartdate=?, apassword=? where adminid=?");

    		ps.setInt	(1,admin.getAdminid());
    		ps.setInt	(2,admin.getHodid());
    		ps.setString(3,admin.getRole());
    		ps.setString(4,admin.getAname());
    		ps.setString(5,admin.getAgender());
    		ps.setString(6,admin.getAnotel());
    		ps.setString(7,admin.getAemail());
    		ps.setString(8,admin.getAdepartment());
    		ps.setString(9,admin.getAposition());
    		ps.setString(10,admin.getAnric());
    		ps.setString(11,admin.getArfid());
    		ps.setString(12,admin.getAstatus());
    		ps.setDate	(13,sqlAstartDate);
    		ps.setString(14,admin.getApassword());
			
			ps.executeUpdate();
			
			System.out.println("Your staffid is " + adminid);
		}
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
	}


}
