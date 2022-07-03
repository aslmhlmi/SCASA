/**
 * 
 */
/**
 * @author USER
 *
 */
package scasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import scasa.connection.ConnectionManager;
import scasa.model.Admin;
import scasa.model.Profile;

public class AdminDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps= null;
	static Statement stmt= null;
	static int adminid, hodid;
	static String  anric, anotel, role, aname, agender, aemail, adepartment, aposition, arfid, astatus, astartdate, apassword,astaffid;
	
	public static Admin getAdmin(Admin admin) {
		adminid = admin.getAdminid();

		String searchQuery = "select * from admins where adminid='" + adminid + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if user exists set the isValid variable to true
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
		
//        adminid 	= admin.getAdminid();
//        hodid 		= admin.getHodid();
//        role 		= admin.getRole();
//        aname 		= admin.getAname();
//        agender 	= admin.getAgender();
//        anotel 		= admin.getAnotel();
//        aemail 		= admin.getAemail();
//        adepartment = admin.getAdepartment();
//        aposition 	= admin.getAposition();
//        anric		= admin.getAnric();
//        arfid 		= admin.getArfid();
//        astatus 	= admin.getAstatus();
//        astartdate 	= admin.getAstartdate();
//        apassword 	= admin.getApassword();
        
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = sdf1.parse(astartdate);
//		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//        
    	try {
    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date date = sdf1.parse(admin.getAstartdate());
    		java.sql.Date sqlAstartDate = new java.sql.Date(date.getTime());
    		
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into admins ( adminid, role, aname, agender, anotel, aemail, adepartment, aposition, arfid, anric, astatus, astartdate, apassword, astaffid) VALUES (ADMINID.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		
    		//insert into admins ( adminid, role, aname, agender, anotel, aemail, adepartment, aposition, arfid, anric, astatus, astartdate, apassword) VALUES (ADMINID.nextval,?,?,?,?,?,?,?,?,?,?,?,?);
    		
//    		ps.setInt	(1,admin.getAdminid());
//    		ps.setInt	(2,admin.getHodid());
    		ps.setString(1,admin.getRole());
    		ps.setString(2,admin.getAname());
    		ps.setString(3,admin.getAgender());
    		ps.setString(4,admin.getAnotel());
    		ps.setString(5,admin.getAemail());
    		ps.setString(6,admin.getAdepartment());
    		ps.setString(7,admin.getAposition());
    		ps.setString(8,admin.getArfid());
    		ps.setString(9,admin.getAnric());
    		ps.setString(10,admin.getAstatus());
    		ps.setDate	(11,sqlAstartDate);
    		ps.setString(12,admin.getApassword());
    		ps.setString(13,admin.getAstaffid());
    		
    		
    		ps.executeUpdate();
    	
    		System.out.println("Your adminid is " 	+ adminid);
    		System.out.println("Your hodid is " 	+ hodid);
            
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
    		  
    		  	  String q = "select * from admins";
    		      ResultSet rs = stmt.executeQuery(q);
    		      
    		      while (rs.next()) {
    		          Admin admin = new Admin();    		          
    		          
    		          admin.setAdminid		(rs.getInt	 ("adminid"));
    		          admin.setHodid		(rs.getInt	 ("hodid"));
    		          admin.setRole			(rs.getString("role"));
    		          admin.setAname		(rs.getString("aname"));
    		          admin.setAgender		(rs.getString("agender"));
    		          admin.setAnotel		(rs.getString("anotel"));
    		          admin.setAemail		(rs.getString("aemail"));
    		          admin.setAdepartment	(rs.getString("adepartment"));
    		          admin.setAposition	(rs.getString("aposition"));    		          
    		          admin.setArfid		(rs.getString("arfid"));
    		          admin.setAnric		(rs.getString("anric"));
    		          admin.setAstatus		(rs.getString("astatus"));
    		          admin.setApassword	(rs.getString("apassword"));
    		          
    		          java.util.Date date = sdf1.parse(rs.getString("astartdate"));  		          
    		          admin.setAstartdate	(sdf1.format(date));  		          

    		          admin.setAstaffid		(rs.getString("astaffid"));
    		          
    		          admins.add(admin);
    		      }
    		  } catch (SQLException | ParseException e) {
    		      e.printStackTrace();
    		  }

    		  return admins;
    	}
    	
    	public void deleteAdmin(int adminid) {
    		String searchQuery = "delete from admins where adminid= '" + adminid + "'";
    		
    		System.out.println(searchQuery);
    		
    		try {
    	
    	        currentCon = ConnectionManager.getConnection();
    	        stmt = currentCon.createStatement();
    	        stmt.executeUpdate(searchQuery);
    	        
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    		
    	}
    	
    	public Admin getAdminById(int id) {
    		Admin admin = new Admin();
    	    try {
    	    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    	    	
    	    	currentCon = ConnectionManager.getConnection();
    	        ps=currentCon.prepareStatement("select * from admins where adminid=?");
    	        //"select select a.adminid,a.hodid,a.role,a.aname,a.gender,a.agender,a.anotel,a.aemail,a.adepartment,a.aposition,a.arfid,a.anric,a.astatus,TO_CHAR(a.astartdate,'yyyy-MM-dd'),a.apassword from admins where adminid=?"
    	        ps.setInt(1, id);
    	        ResultSet rs = ps.executeQuery();

    	        if (rs.next()) {
    	        	
    	        	admin.setAdminid	(rs.getInt	 ("adminid"));
  		          	admin.setHodid		(rs.getInt	 ("hodid"));
  		          	admin.setRole		(rs.getString("role"));
  		          	admin.setAname		(rs.getString("aname"));
  		          	admin.setAgender	(rs.getString("agender"));
  		          	admin.setAnotel		(rs.getString("anotel"));
  		          	admin.setAemail		(rs.getString("aemail"));
  		          	admin.setAdepartment(rs.getString("adepartment"));
  		          	admin.setAposition	(rs.getString("aposition"));
  		          	admin.setArfid		(rs.getString("arfid"));
  		          	admin.setAnric		(rs.getString("anric"));
  		          	admin.setAstatus	(rs.getString("astatus"));
  		          	
  		          	//admin.setAstartdate	(rs.getString("astartdate"));
  		          	
  		          	java.util.Date date = sdf1.parse(rs.getString("astartdate"));  		          
			        admin.setAstartdate	(sdf1.format(date));
			        
  		          	admin.setApassword	(rs.getString("apassword"));
  		          	admin.setAstaffid	(rs.getString("astaffid"));
  		          	
  		          	
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    	    
    	    return admin;
    	}

//    	public void updateProfile(Admin admin) {
//    		
//            adminid 	= admin.getAdminid();
////          hodid	 	= admin.getHodid();
//            role	 	= admin.getRole();
//            aname 		= admin.getAname();
//            agender 	= admin.getAgender();
//            anotel 		= admin.getAnotel();
//            aemail	 	= admin.getAemail();
//            adepartment	= admin.getAdepartment();
//            aposition 	= admin.getAposition();
//            arfid		= admin.getArfid();
//            anric		= admin.getAnric();
//            astatus 	= admin.getAstatus();
////			astartdate 	= admin.getAstartdate();
//            apassword 	= admin.getApassword();
//            astaffid 	= admin.getAstaffid();
//            
//            
//
//    	    String searchQuery = "UPDATE admins SET  " + 
//    	    		"adminid	='" + adminid +"' ," + 
//    	    		"hodid		='" + hodid +"' ," + 
//    	    		"role		='" + role +"' ," + 
//    	    		"aname		='" + aname +"'," + 
//    	    		"agender	='" + agender +"' ," + 
//    	    		"anotel		='" + anotel +"' ," + 
//    	    		"aemail		='" + aemail +"' ," + 
//    	    		"adepartment='" + adepartment +"' ," + 
//    	    		"aposition	='"	+ aposition +"' ," + 
//    	    		"arfid		='" + arfid +"' ," + 
//    	    		"anric		='" + anric +"' ," + 
//    	    		"astatus	='" + astatus +"' " + 
//    	    		"apassword	='" + apassword +"' " + 
//    	    		"astaffid	='" + astaffid +"' " + 
//    	    		
//    	    		
//    	    		"WHERE adminid= '" + adminid +"'";
//    	    		
////    	    				"UPDATE admins SET  adminid='" + adminid + "' , hodid='" + hodid + "' , role='" + role + "' , aname='" + aname  + "' " 
////							+ ", agender='" + agender + "' , anotel='" + anotel  + "' , aemail='" + aemail + "' , "
////							+ ", adepartment='" + adepartment + "' , aposition='" + aposition  + "' , arfid='" + arfid + "' , "
////							+ "', anric='" + anric +"' , astatus='" + astatus + "' , astartdate='" + astartdate + "' , apassword='" + apassword + "' ,"
////							+ "WHERE adminid= '" + adminid + "'";
//    		
////    	    System.out.println(searchQuery);
//    	    
//    	    
//    		try {
//    	
//    	        currentCon = ConnectionManager.getConnection();
//    	        stmt = currentCon.createStatement();
//    	        stmt.executeUpdate(searchQuery);
//    	        
//    	    } catch (SQLException e) {
//    	        e.printStackTrace();
//    	    }
//    		
//    	}
    	
    	public void updateAdmin(Admin admin) {
    		
    		System.out.print("haa ni dia dah masuk update admin dao");
    		
            adminid 	= admin.getAdminid();
            hodid	 	= admin.getHodid();
            role	 	= admin.getRole();
            aname 		= admin.getAname();
            agender 	= admin.getAgender();
            anotel 		= admin.getAnotel();
            aemail	 	= admin.getAemail();
            adepartment	= admin.getAdepartment();
            aposition 	= admin.getAposition();
            arfid		= admin.getArfid();
            anric		= admin.getAnric();
            astatus 	= admin.getAstatus();
//			astartdate 	= admin.getAstartdate();
            apassword 	= admin.getApassword();
            astaffid 	= admin.getAstaffid();
            
            

    	    String searchQuery = "UPDATE admins SET  " + 
    	    		"adminid	='" + adminid +"' ," + 
    	    		"hodid		='" + hodid +"' ," + 
    	    		"role		='" + role +"' ," + 
    	    		"aname		='" + aname +"'," + 
    	    		"agender	='" + agender +"' ," + 
    	    		"anotel		='" + anotel +"' ," + 
    	    		"aemail		='" + aemail +"' ," + 
    	    		"adepartment='" + adepartment +"' ," + 
    	    		"aposition	='"	+ aposition +"' ," + 
    	    		"arfid		='" + arfid +"' ," + 
    	    		"anric		='" + anric +"' ," + 
    	    		"astatus	='" + astatus +"' ," + 
    	    		"astaffid	='" + astaffid +"' " + 
    	    		
    	    		
    	    		"WHERE adminid= '" + adminid +"'";
    	    		
//    	    				"UPDATE admins SET  adminid='" + adminid + "' , hodid='" + hodid + "' , role='" + role + "' , aname='" + aname  + "' " 
//							+ ", agender='" + agender + "' , anotel='" + anotel  + "' , aemail='" + aemail + "' , "
//							+ ", adepartment='" + adepartment + "' , aposition='" + aposition  + "' , arfid='" + arfid + "' , "
//							+ "', anric='" + anric +"' , astatus='" + astatus + "' , astartdate='" + astartdate + "' , apassword='" + apassword + "' ,"
//							+ "WHERE adminid= '" + adminid + "'";
    		
    	    System.out.println(searchQuery);
    	    
    	    
    		try {
    	
    	        currentCon = ConnectionManager.getConnection();
    	        stmt = currentCon.createStatement();
    	        stmt.executeUpdate(searchQuery);
    	        
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    		
    	}
    	
    	public void updateAdmin1(Admin admin) {
    		
    		System.out.print("haa ni dia dah masuk update admin dao");
    		
            adminid 	= admin.getAdminid();
//          hodid	 	= admin.getHodid();
            role	 	= admin.getRole();
            aname 		= admin.getAname();
            agender 	= admin.getAgender();
            anotel 		= admin.getAnotel();
            aemail	 	= admin.getAemail();
            adepartment	= admin.getAdepartment();
            aposition 	= admin.getAposition();
            arfid		= admin.getArfid();
            anric		= admin.getAnric();
            astatus 	= admin.getAstatus();
//			astartdate 	= admin.getAstartdate();
            apassword 	= admin.getApassword();
            astaffid 	= admin.getAstaffid();              

    	    String searchQuery = "UPDATE admins SET  " + 
    	    		"adminid	='" + adminid +"' ," + 
    	    		"role		='" + role +"' ," + 
    	    		"aname		='" + aname +"'," + 
    	    		"agender	='" + agender +"' ," + 
    	    		"anotel		='" + anotel +"' ," + 
    	    		"aemail		='" + aemail +"' ," + 
    	    		"adepartment='" + adepartment +"' ," + 
    	    		"aposition	='"	+ aposition +"' ," + 
    	    		"arfid		='" + arfid +"' ," + 
    	    		"anric		='" + anric +"' ," + 
    	    		"astatus	='" + astatus +"' ," + 
    	    		"apassword	='" + apassword +"' ," + 
    	    		"astaffid	='" + astaffid +"' " + 
    	    		
    	    		
    	    		"WHERE adminid= '" + adminid +"'";
    	    		
//    	    				"UPDATE admins SET  adminid='" + adminid + "' , hodid='" + hodid + "' , role='" + role + "' , aname='" + aname  + "' " 
//							+ ", agender='" + agender + "' , anotel='" + anotel  + "' , aemail='" + aemail + "' , "
//							+ ", adepartment='" + adepartment + "' , aposition='" + aposition  + "' , arfid='" + arfid + "' , "
//							+ "', anric='" + anric +"' , astatus='" + astatus + "' , astartdate='" + astartdate + "' , apassword='" + apassword + "' ,"
//							+ "WHERE adminid= '" + adminid + "'";
    		
    	    System.out.println(searchQuery);
    	    
    	    
    		try {
    	
    	        currentCon = ConnectionManager.getConnection();
    	        stmt = currentCon.createStatement();
    	        stmt.executeUpdate(searchQuery);
    	        
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    		
    	}
    	
    	public void updatePassword(Admin admin) {
    		
            
    		apassword 	= admin.getApassword();
    		adminid 	= admin.getAdminid();

    	    String searchQuery = "UPDATE admins SET "
    	    		+ "apassword='" + apassword + "' "
    	    		
    	    		
    				+ "WHERE adminid= " + adminid + "";
    	    
    	    System.out.println(searchQuery);
    	    try {
    	
    	        currentCon = ConnectionManager.getConnection();
    	        stmt = currentCon.createStatement();
    	        stmt.executeUpdate(searchQuery);
    	        
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    		
    	}
	
	
}