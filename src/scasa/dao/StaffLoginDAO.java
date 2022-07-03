//package scasa.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.apache.catalina.connector.Response;
//
//import scasa.connection.ConnectionManager;
//import scasa.model.Staff;
//
//public class StaffLoginDAO {
//	
//	static Connection currentCon = null;
//	static ResultSet rs = null; 
//	static PreparedStatement ps= null;
//	static Statement stmt= null;
//	static int staffid, snotel, snric;
//	static String sname, sgender, semail, sdepartment, sposition, srfid, sstatus, sstartdate ;
//
//	public static Staff getUser(Staff staff) {
//		staffid = staff.getStaffid();
//		
//		String searchQuery = "select * from staffs where staffid='" + staffid + "'";     
//        try {
//            currentCon = ConnectionManager.getConnection();
//            stmt = currentCon.createStatement();
//            rs = stmt.executeQuery(searchQuery);
//            boolean more = rs.next();
//            
//            System.out.println(searchQuery);
//
//            // if staff exists set the isValid variable to true
//            if (more) {
//                staff.setValid(true);
//           	}
//           
//            else if (!more) {
//            	staff.setValid(false);
//            }
//           
//        }
//
//        catch (Exception ex) {
//            System.out.println("Log In failed: An Exception has occurred! " + ex);
//        }
//
//        finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (Exception e) {
//                }
//                rs = null;
//            }
//
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (Exception e) {
//                }
//                stmt = null;
//            }
//
//            if (currentCon != null) {
//                try {
//                    currentCon.close();
//                } catch (Exception e) {
//                }
//
//                currentCon = null;
//            }
//        }
//
//        return staff;
//	}
//	
//	public void add(Staff staff) {
//		
//        staffid	 	= staff.getStaffid();
//        sname     	= staff.getSname();
//        sgender     = staff.getSgender();
//        snotel     	= staff.getSnotel();
//        semail    	= staff.getSemail();
//        sdepartment = staff.getSdepartment();
//        sposition  	= staff.getSposition();
//        snric	    = staff.getSnric();
//        srfid 		= staff.getSrfid();
//        sstatus 	= staff.getSstatus();
//        sstartdate 	= staff.getSstartdate();
//        
//    	try {
//    		currentCon = ConnectionManager.getConnection();
//    		ps=currentCon.prepareStatement("insert into staffs (staffid, sname, sgender, snotel, semail, sdepartment, sposition, snirc, srfid, sstatus, sstartdate)values(?,?,?,?,?,?,?,?,?,?,?)");
//    		ps.setInt	(1,staffid);
//    		ps.setString(2,sname);
//    		ps.setString(3,sgender);
//    		ps.setInt	(4,snotel);
//    		ps.setString(5,semail);
//    		ps.setString(6,sdepartment);
//    		ps.setString(7,sposition);
//    		ps.setInt	(8,snric);
//    		ps.setString(9,srfid);
//    		ps.setString(10,sstatus);
//    		ps.setString(11,sstartdate);
//    		ps.executeUpdate();
//            
//    	}
//
//    	catch (Exception ex) {
//    		System.out.println("failed: An Exception has occurred! " + ex);
//    	}
//
//    	finally {
//    		if (ps != null) {
//    			try {
//    				ps.close();
//    			} catch (Exception e) {
//    			}
//    			ps = null;
//    		}
//    		
//    		if (currentCon != null) {
//    			try {
//    				currentCon.close();
//    			} catch (Exception e) {
//    			}
//    			currentCon = null;
//    		}
//    	}
//		
//		
//	}
//	
//	public List<Staff> getAllStaff() {
//		List<Staff> staffs = new ArrayList<Staff>();
//		  
//		  try {
//		  	currentCon = ConnectionManager.getConnection();
//		  	stmt = currentCon.createStatement();
//		  
//		  	  String q = "select * from staffs where role = 'staffs' order by semail";
//		      ResultSet rs = stmt.executeQuery(q);
//		      
//		      while (rs.next()) {
//		          Staff staff = new Staff();
//		          staff.setStaffid		(rs.getInt		("staffid"));
//		          staff.setSname		(rs.getString	("sname"));
//		          staff.setSgender		(rs.getString	("sgender"));
//		          staff.setSnotel		(rs.getInt		("snotel"));
//		          staff.setSemail		(rs.getString	("semail"));
//		          staff.setSdepartment	(rs.getString	("sdepartment"));
//		          staff.setSposition	(rs.getString	("sposition"));
//		          staff.setSnric		(rs.getInt		("snric"));
//		          staff.setSrfid		(rs.getString	("srfid"));
//		          staff.setSstatus		(rs.getString	("sstatus"));
//		          staff.setSstartdate	(rs.getString	("sstartdate"));
//		          staffs.add(staff);
//		      }
//		  } catch (SQLException e) {
//		      e.printStackTrace();
//		  }
//
//		  return staffs;
//	}
//	
//	public void deleteUser(String staffid) {
//		try {
//	    	currentCon = ConnectionManager.getConnection();
//	    	ps=currentCon.prepareStatement("delete from staffs where staffid=?");
//	        ps.setString(1, staffid);
//	        ps.executeUpdate();
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
//	
//	
//	public Staff getStaffById(String semail) {
//		Staff staff = new Staff();
//	    try {
//	    	currentCon = ConnectionManager.getConnection();
//	        ps=currentCon.prepareStatement("select * from staffs where staffid=?");
//	        
//	        ps.setInt(1, staffid);
//	        ResultSet rs = ps.executeQuery();
//
//	        if (rs.next()) {
//		          staff.setStaffid		(rs.getInt		("staffid"));
//		          staff.setSname		(rs.getString	("sname"));
//		          staff.setSgender		(rs.getString	("sgender"));
//		          staff.setSnotel		(rs.getInt		("snotel"));
//		          staff.setSemail		(rs.getString	("semail"));
//		          staff.setSdepartment	(rs.getString	("sdepartment"));
//		          staff.setSposition	(rs.getString	("sposition"));
//		          staff.setSnric		(rs.getInt		("snric"));
//		          staff.setSrfid		(rs.getString	("srfid"));
//		          staff.setSstatus		(rs.getString	("sstatus"));
//		          staff.setSstartdate	(rs.getString	("sstartdate"));
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    
//	    
//	    return staff;
//	}
//
//	public void updateUser(Staff staff) {
//		
//        staffid	 	= staff.getStaffid();
//        sname     	= staff.getSname();
//        sgender     = staff.getSgender();
//        snotel 		= staff.getSnotel();
//        semail    	= staff.getSemail();
//        sdepartment = staff.getSdepartment();
//        sposition  	= staff.getSposition();
//        snric 		= staff.getSnric();
//        srfid 		= staff.getSrfid();
//        sstatus 	= staff.getSstatus();
//        sstartdate 	= staff.getSstartdate();
//		
//		try {
//	
//	        currentCon = ConnectionManager.getConnection();
//			ps=currentCon.prepareStatement("update staffs SET staffid=?, sname=?, sgender=? snotel=?, semail=?, sdepartment=?, sposition=?, snric=?, srfid=?, sstatus=?, sstartdate=? where staffid=?");
//
//    		ps.setInt	(1,staffid);
//    		ps.setString(2,sname);
//    		ps.setString(3,sgender);
//    		ps.setInt	(4,snotel);
//    		ps.setString(5,semail);
//    		ps.setString(6,sdepartment);
//    		ps.setString(7,sposition);
//    		ps.setInt	(8,snric);
//    		ps.setString(9,srfid);
//    		ps.setString(10,sstatus);
//    		ps.setString(11,sstartdate);
//			
//			ps.executeUpdate();
//		}
//		catch (Exception ex) {
//			System.out.println("failed: An Exception has occurred! " + ex);
//		}
//		finally {
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (Exception e) {
//				}
//				ps = null;
//			}
//			if (currentCon != null) {
//				try {
//					currentCon.close();
//				} catch (Exception e) {
//				}
//				currentCon = null;
//			}
//		}
//	}
//
//
//}
