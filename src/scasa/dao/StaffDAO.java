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
import java.time.LocalDate;

import scasa.connection.ConnectionManager;
import scasa.model.Staff;

public class StaffDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps= null;
	static Statement stmt= null;
	static int staffid;
	static long snric, snotel;
	static String sname, sgender, semail, sdepartment, sposition, srfid, sstatus, sstartdate;
	
	public static Staff getStaff(Staff staff) {
		staffid = staff.getStaffid();

		String searchQuery = "select * from staffs where staffid='" + staffid + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if user exists set the isValid variable to true
            if (more) {
                staff.setValid(true);
           	}
           
            else if (!more) {
            	staff.setValid(false);
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

        return staff;
	}
	
	public void add(Staff staff)  {
		
//        staffid 	= staff.getStaffid();
//        sname 		= staff.getSname();
//        sgender 	= staff.getSgender();
//        snotel 		= staff.getSnotel();
//        semail 		= staff.getSemail();
//        sdepartment = staff.getSdepartment();
//        sposition 	= staff.getSposition();
//        snric 		= staff.getSnric();
//        srfid 		= staff.getSrfid();
//        sstatus 	= staff.getSstatus();
//        sstartdate 	= staff.getSstartdate();
//        
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = sdf1.parse(sstartdate);
//		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        
    	try {
    		

    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    		java.util.Date date = sdf1.parse(staff.getSstartdate());
    		java.sql.Date sqlSstartDate = new java.sql.Date(date.getTime());
    		
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into staffs (staffid, sname, sgender, snotel, semail, sdepartment, sposition, snric, srfid, sstatus, sstartdate)values(?,?,?,?,?,?,?,?,?,?,?)");
    		ps.setInt	(1,staff.getStaffid());
    		ps.setString(2,staff.getSname());
    		ps.setString(3,staff.getSgender());
    		ps.setLong	(4,staff.getSnotel());
    		ps.setString(5,staff.getSemail());
    		ps.setString(6,staff.getSdepartment());
    		ps.setString(7,staff.getSposition());
    		ps.setLong	(8,staff.getSnric());
    		ps.setString(9,staff.getSrfid());
    		ps.setString(10,staff.getSstatus());
    		ps.setDate	(11,sqlSstartDate);
    		
    		
    		ps.executeUpdate();
    	
    		System.out.println("Your staffid is " + staffid);
            
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
		
    	public List<Staff> getAllStaff() {
    		List<Staff> staffs = new ArrayList<Staff>();
    		  
    		  try {
    			  

    	    	  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    	    		
    	    	  currentCon = ConnectionManager.getConnection();
    	    	  stmt = currentCon.createStatement();
    		  
    		  	  String q = "select * from staffs";
    		      ResultSet rs = stmt.executeQuery(q);
    		      
    		      while (rs.next()) {
    		          Staff staff = new Staff();    		          
    		          
    		          staff.setStaffid		(rs.getInt	 ("staffid"));
    		          staff.setSname		(rs.getString("sname"));
    		          staff.setSgender		(rs.getString("sgender"));
    		          staff.setSnotel		(rs.getLong	 ("snotel"));
    		          staff.setSemail		(rs.getString("semail"));
    		          staff.setSdepartment	(rs.getString("sdepartment"));
    		          staff.setSposition	(rs.getString("sposition"));
    		          staff.setSnric		(rs.getLong	 ("snric"));
    		          staff.setSrfid		(rs.getString("srfid"));
    		          staff.setSstatus		(rs.getString("sstatus"));
    		          
    		          java.util.Date date = sdf1.parse(rs.getString("sstartdate"));
//      	    		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());    		           		          
    		          
    		          staff.setSstartdate	(sdf1.format(date));
    		          
    		          staffs.add(staff);
    		      }
    		  } catch (SQLException | ParseException e) {
    		      e.printStackTrace();
    		  }

    		  return staffs;
    	}
    	
    	public void deleteStaff(int staffid) {
    		String searchQuery = "delete from staffs where staffid=" + "'" + staffid + "'";
    		
    		System.out.println(searchQuery);
    		
    		try {
    	
    	        currentCon = ConnectionManager.getConnection();
    	        stmt = currentCon.createStatement();
    	        stmt.executeUpdate(searchQuery);
    	        
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    		
    	}
    	
    	public Staff getStaffById(int id) {
    		Staff staff = new Staff();
    	    try {
    	    	currentCon = ConnectionManager.getConnection();
    	        ps=currentCon.prepareStatement("select * from staffs where staffid=?");
    	        
    	        ps.setInt(1, id);
    	        ResultSet rs = ps.executeQuery();

    	        if (rs.next()) {
    	        	
    	        	staff.setStaffid	(rs.getInt	 ("staffid"));
  		          	staff.setSname		(rs.getString("sname"));
  		          	staff.setSgender	(rs.getString("sgender"));
  		          	staff.setSnotel		(rs.getLong	 ("snotel"));
  		          	staff.setSemail		(rs.getString("semail"));
  		          	staff.setSdepartment(rs.getString("sdepartment"));
  		          	staff.setSposition	(rs.getString("sposition"));
  		          	staff.setSnric		(rs.getLong	 ("snric"));
  		          	staff.setSrfid		(rs.getString("srfid"));
  		          	staff.setSstatus	(rs.getString("sstatus"));
  		          	staff.setSstartdate	(rs.getString("sstartdate"));
  		          	
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    
    	    
    	    return staff;
    	}
    	
    	public Staff getStaffBySrfid(String srfid) {
    		System.out.println("getStaffBySrfid " + srfid);
    		Staff staff = new Staff();
    	    try {
    	    	currentCon = ConnectionManager.getConnection();
    	        ps=currentCon.prepareStatement("select * from staffs where srfid=?");
    	        
    	        ps.setString(1, srfid);
    	        ResultSet rs = ps.executeQuery();

    	        if (rs.next()) {
    	        	
    	        	staff.setStaffid	(rs.getInt	 ("staffid"));
  		          	staff.setSname		(rs.getString("sname"));
  		          	staff.setSgender	(rs.getString("sgender"));
  		          	staff.setSnotel		(rs.getLong	 ("snotel"));
  		          	staff.setSemail		(rs.getString("semail"));
  		          	staff.setSdepartment(rs.getString("sdepartment"));
  		          	staff.setSposition	(rs.getString("sposition"));
  		          	staff.setSnric		(rs.getLong	 ("snric"));
  		          	staff.setSrfid		(rs.getString("srfid"));
  		          	staff.setSstatus	(rs.getString("sstatus"));
  		          	staff.setSstartdate	(rs.getString("sstartdate"));
  		          	
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    
    	    
    	    return staff;
    	}

    	public void updateStaff(Staff staff) {
    		
            staffid		= staff.getStaffid();
            sname 		= staff.getSname();
            sgender 	= staff.getSgender();
            snotel 		= staff.getSnotel();
            semail	 	= staff.getSemail();
            sdepartment	= staff.getSdepartment();
            sposition 	= staff.getSposition();
            snric		= staff.getSnric();
            srfid		= staff.getSrfid();
            sstatus 	= staff.getSstatus();
            sstartdate 	= staff.getSstartdate();

    	    String searchQuery = "UPDATE staffs SET  " +
    	    		" sname		='" + sname  + "' ,"	+
    	    		" sgender	='" + sgender + "' , " + 
    	    		"snotel		='" + snotel  + "' , " +
    	    		"semail		='" + semail + "' , " +
    	    		"sdepartment='" + sdepartment + "' ," +
    	    		"sposition	='" + sposition  + "' ," +
    	    		"snric		='" + snric + "', " +
    	    		"srfid		='" + srfid + "' , " +
    	    		"sstatus	='" + sstatus + "' " +
    	    		
    	    		"WHERE staffid= '" + staffid + "'";
    	    
    	    System.out.println(searchQuery);
    		try {
    	
    	        currentCon = ConnectionManager.getConnection();
    	        stmt = currentCon.createStatement();
    	        stmt.executeUpdate(searchQuery);
    	        
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    		
    	}
    	
    	//DISPLAY NUMBER OF TOTAL STAFF
    	public int getTotalStaff() {
    		try {
    			currentCon = ConnectionManager.getConnection();
    			ps = currentCon.prepareStatement(
    					"select count(staffid) as count_total_staff from staffs");

    			ps.setString(1, LocalDate.now().toString());
    			ResultSet rs = ps.executeQuery();

    			if (rs.next()) {
    				System.out.println(rs.getInt("count_total_staff"));
    				return rs.getInt("count_total_staff");
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}

    		return 0;
    	}
	
	
}