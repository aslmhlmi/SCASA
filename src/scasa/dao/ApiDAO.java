package scasa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import scasa.connection.ConnectionManager;
import scasa.model.Admin;
//import scasa.model.Admin;
import scasa.model.Api;
import scasa.model.Staff;

public class ApiDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps= null;
	static Statement stmt= null;
	
	static float temp;
	static String  rfid;
	
		public static Api getApi(Api api) {
			rfid = api.getRfid(); 
			
			System.out.println(rfid);
			System.out.println(temp);

			String searchQuery = "select * from api where srfid='" + rfid + "'"; 
	
	        try {
	            currentCon = ConnectionManager.getConnection();
	            stmt = currentCon.createStatement();
	            rs = stmt.executeQuery(searchQuery);
	            boolean more = rs.next();
	            
	            System.out.println(searchQuery);
	
	            // if user exists set the isValid variable to true
//	            if (more) {
//	                api.setRfid(true);
//	           	}
//	           
//	            else if (!more) {
//	            	api.setRfid(false);
//	            }
	           
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
	
	        return api;
	
		}
	
//		public void add(Api api) {
//	     
//		  	try {
//		  		
//		  		currentCon = ConnectionManager.getConnection();
//		  		ps=currentCon.prepareStatement("insert into admins ( adminid, role, aname, agender, anotel, aemail, adepartment, aposition, arfid, anric, astatus, astartdate, apassword, astaffid) VALUES (ADMINID.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//		
//		  		ps.setString(1,api.getRfid());
//		  		ps.setFloat (2,api.getTemp());	  		
//		  		
//		  		ps.executeUpdate();
//		  	
//		  		System.out.println("Your RFID is " 			+ rfid);
//		  		System.out.println("Your Temperature is " 	+ temp);
//		          
//		  	}
//		
//		  	catch (Exception ex) {
//		  		System.out.println("failed: An Exception has occurred! " + ex);
//		  	}
//		
//		  	finally {
//		  		if (ps != null) {
//		  			try {
//		  				ps.close();
//		  			} catch (Exception e) {
//		  			}
//		  			ps = null;
//		  		}
//		  		
//		  		if (currentCon != null) {
//		  			try {
//		  				currentCon.close();
//		  			} catch (Exception e) {
//		  			}
//		  			currentCon = null;
//		  			}
//		  		}
//		  	
//			}

    	public void addApi(Api api, Staff staff) {
//        	public void updateApi(String rfid, float temp) {
        		
        		System.out.print("haa ni dia dah masuk add api dao ");
        		
//        	    Timestamp stamp = new Timestamp(System.currentTimeMillis());//your timestamp goes here
//        	    Date date = new Date(stamp.getTime());
//        	    
//        		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        		java.util.Date date = sdf1.parse(api.getCheckin());
//        		java.sql.Date sqlCheckin = new java.sql.Date(date.getTime());
//        		
//        		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//        		java.util.Date date1 = sdf2.parse(api.getAdate());
//        		java.sql.Date sqlAdate = new java.sql.Date(date1.getTime());
        		
                rfid 	= api.getRfid();
                temp	= api.getTemp();  
                
                // find by staff rfid
//                String staffid = "SELECT staffid FROM staffs WHERE srfid = " + rfid +";";

//        	    String searchQuery = ("INSERT INTO ATTENDANCES (aid,staffid,btemp,checkin,adate) VALUES (naq_val,staffid,temp,?,?)");
//        	    		
//        	    		"insert into attendances where  " + 
//        	    		"srfid	='" + rfid +"' ," + 
//        	    		"btemp	='" + temp +"' " + 
//        	    		
//        	    		"WHERE adminid= '" + rfid +"'";
//        	    
//        	    		("INSERT INTO ATTENDANCES (aid,staffid,btemp,checkin,checkout,adate) VALUES (naq_val,?,temp,?,?,?)");
//        	    		
        	    
        	    
    	  		System.out.println("Your RFID is "+ rfid);
    	  		System.out.println("Your Temperature is "+ temp + "°C Celcius ");
    	  		System.out.println("staff.getStaffid()" +  staff.getStaffid());
    	  		
        		try {
        	
        			currentCon = ConnectionManager.getConnection();
            		ps=currentCon.prepareStatement("INSERT INTO ATTENDANCES (aid,staffid,sname,sposition,sdepartment,srfid,btemp,checkin,adate) VALUES (aid.nextval,?,?,?,?,?,?,?,?)");
            		ps.setInt		(1, staff.getStaffid());
            		ps.setString	(2, staff.getSname());
            		ps.setString	(3, staff.getSposition());
            		ps.setString	(4, staff.getSdepartment());
            		ps.setString	(5, staff.getSrfid());            		
            		ps.setFloat		(6, api.getTemp());
            		ps.setTimestamp (7, Timestamp.valueOf(LocalDateTime.now()));
            		ps.setDate		(8, Date.valueOf(LocalDate.now()));
            		
            		
//            		ps.setString	(3, LocalDateTime.now().toString());
//            		ps.setDate		(4, Date.valueOf(LocalDate.now()));
            		
            		
//            		System.out.println(searchQuery);
            		ps.executeUpdate();
        	        
        	    } catch (SQLException e) {
        	        e.printStackTrace();
        	    }
        		
        	} 	
		
//    	public void updateApi(Api api) {
//    	public void updateApi(String rfid, float temp) {
//    		
//    		System.out.print("haa ni dia dah masuk update api dao");
//    		
//            rfid 	= api.getRfid();
//            temp	= api.getTemp();            
//
//    	    String searchQuery = "UPDATE admins SET  " + 
//    	    		"astatus	='" + rfid +"' ," + 
//    	    		"astaffid	='" + temp +"' " + 
//    	    		
//    	    		"WHERE adminid= '" + rfid +"'";
//    	    		
//    	    System.out.println(searchQuery);
//    	    
//	  		System.out.println("Your RFID is " 			+ rfid);
//	  		System.out.println("Your Temperature is " 	+ temp + "°C Celcius ");
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
	

}
