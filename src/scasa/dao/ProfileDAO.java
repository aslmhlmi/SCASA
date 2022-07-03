package scasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.text.*;
import java.util.*;
import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import scasa.connection.ConnectionManager;
import scasa.model.Profile;
import scasa.model.Admin;


public class ProfileDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps= null;
	static Statement stmt= null;
	static int adminid, hodid;
	static String role, aname, anotel, agender, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, apassword;

	public static Profile getProfile(Profile profile) {
		adminid = profile.getAdminid();

		String searchQuery = "select * from admins where adminid='" + adminid + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if Admin exists set the isValid variable to true
            
            if (more) {
                profile.setValid(true);
           	}
           
            else if (!more) {
            	profile.setValid(false);
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

        return profile;
	}
	
	public void add(Profile profile) {
		
//        adminid 	= profile.getAdminid();
//        hodid 		= profile.getHodid();
//        role 		= profile.getRole();
//        aname 		= profile.getAname();
//        agender 	= profile.getAgender();
//        anotel 		= profile.getAnotel();
//        aemail 		= profile.getAemail();
//        adepartment = profile.getAdepartment();
//        aposition 	= profile.getAposition();
//        anric		= profile.getAnric();
//        arfid 		= profile.getArfid();
//        astatus 	= profile.getAstatus();
//        astartdate 	= profile.getAstartdate();
//        apassword 	= profile.getApassword();
        
    	try {
    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date date = sdf1.parse(profile.getAstartdate());
    		java.sql.Date sqlAstartDate = new java.sql.Date(date.getTime());
    		
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into admins ( adminid,hodid, role, aname, agender, anotel, aemail, adepartment, aposition, arfid, anric, astatus, astartdate, apassword)values(admins_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		ps.setInt	(1,profile.getAdminid());
    		ps.setInt	(2,profile.getHodid());
    		ps.setString(3,profile.getRole());
    		ps.setString(4,profile.getAname());
    		ps.setString(5,profile.getAgender());
    		ps.setString(6,profile.getAnotel());
    		ps.setString(7,profile.getAemail());
    		ps.setString(8,profile.getAdepartment());
    		ps.setString(9,profile.getAposition());
    		ps.setString(10,profile.getArfid());
    		ps.setString(11,profile.getAnric());
    		ps.setString(12,profile.getAstatus());
    		ps.setDate	(13,sqlAstartDate);
    		ps.setString(14,profile.getApassword());
    		
    		
    		ps.executeUpdate();
    	
    		System.out.println("Your adminid is " + adminid);
    		System.out.println("Your hodid is " + hodid);
            
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
	
	public List<Profile> getAllAdmin() {
		List<Profile> profiles = new ArrayList<Profile>();
		  
		  try {
			  
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from admins";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		    	  Profile profile = new Profile();
		          
		          
		    	  profile.setAdminid		(rs.getInt	 ("adminid"));
		    	  profile.setHodid			(rs.getInt	 ("hodid"));
		    	  profile.setRole			(rs.getString("role"));
		    	  profile.setAname			(rs.getString("aname"));
		    	  profile.setAgender		(rs.getString("agender"));
		    	  profile.setAnotel			(rs.getString ("anotel"));
		    	  profile.setAemail			(rs.getString("aemail"));
		    	  profile.setAdepartment	(rs.getString("adepartment"));
		    	  profile.setAposition		(rs.getString("aposition"));    		          
		    	  profile.setArfid			(rs.getString("arfid"));
		    	  profile.setAnric			(rs.getString("anric"));
		    	  profile.setAstatus		(rs.getString("astatus"));
		    	  
		    	  java.util.Date date = sdf1.parse(rs.getString("astartdate"));			          
		    	  profile.setAstartdate		(sdf1.format(date));
		          
		    	  //profile.setAstartdate		(rs.getString("astartdate"));
		          profile.setApassword		(rs.getString("apassword"));
		          

		    	  profiles.add(profile);
		      }
		  } catch (SQLException | ParseException e) {
		      e.printStackTrace();
		  }

		  return profiles;
	}
	
	public Profile getAdminById(int id) {
		Profile profile = new Profile();
	    try {
	    	
	    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    	
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from admins where adminid=?");
	        
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	profile.setAdminid		(rs.getInt	 ("adminid"));
	        	profile.setHodid		(rs.getInt	 ("hodid"));
	        	profile.setRole			(rs.getString("role"));
	        	profile.setAname		(rs.getString("aname"));
	          	profile.setAgender		(rs.getString("agender"));
	          	profile.setAnotel		(rs.getString("anotel"));
	          	profile.setAemail		(rs.getString("aemail"));
	          	profile.setAdepartment	(rs.getString("adepartment"));
	          	profile.setAposition	(rs.getString("aposition"));
	          	profile.setArfid		(rs.getString("arfid"));
	          	profile.setAnric		(rs.getString("anric"));
	          	profile.setAstatus		(rs.getString("astatus"));
	          	
	          	java.util.Date date = sdf1.parse(rs.getString("astartdate"));			          
		    	profile.setAstartdate		(sdf1.format(date));
		    	  
	          	profile.setAstartdate	(rs.getString("astartdate"));
	          	profile.setApassword	(rs.getString("apassword"));

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    return profile;
	}
	
	public void updateProfile(Profile profile) {
		
        adminid 	= profile.getAdminid();
        hodid	 	= profile.getHodid();
        role	 	= profile.getRole();
        aname 		= profile.getAname();
        agender 	= profile.getAgender();
        anotel 		= profile.getAnotel();
        aemail	 	= profile.getAemail();
        adepartment	= profile.getAdepartment();
        aposition 	= profile.getAposition();
        arfid		= profile.getArfid();
        anric		= profile.getAnric();
        astatus 	= profile.getAstatus();
        astartdate 	= profile.getAstartdate();
        apassword 	= profile.getApassword();
        

	    String searchQuery = "UPDATE admins SET  hodid='" + hodid + "' , role='" + role + "' , aname='" + aname  + "' " 
				+ ", agender='" + agender + "' , anotel='" + anotel  + "' , aemail='" + aemail + "' , "
				+ ", adepartment='" + adepartment + "' , aposition='" + aposition  + "' , arfid='" + arfid + "' , "
				+ "', anric='" + anric +"' , astatus='" + astatus + "' , astartdate='" + astartdate + "' , apassword='" + apassword + "' ,"
				+ "WHERE adminid= '" + adminid + "'";
	    
	    try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public void updateProfilepassword(Profile profile) {
		
        
        apassword 	= profile.getApassword();

	    String searchQuery = "UPDATE admins SET apassword='" + apassword + "' ,"
				+ "WHERE adminid= '" + adminid + "'";

	    try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	
}
