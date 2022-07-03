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
import scasa.model.Staff;
import scasa.model.Attendance;

public class SenddataDAO {
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

}
