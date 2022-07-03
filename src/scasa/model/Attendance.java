/**
 * 
 */
package scasa.model;

import scasa.model.Attendance;

public class Attendance {
	private int aid;		 		// 	Attendance ID
	private int staffid;			//	Staff ID
	private int adminid; 		// 	Admin ID
	private float btemp;  			// 	Body Temperature
	private String checkin; 		// 	Check In
	private String checkout; 		// 	Check Out
	private String adate;   		// 	Attendance Date 

	//.......................   STAFF   ......................../
	private String sname;   		// Staff Name 
	private String sdepartment; 	// Staff Department 
	private String sposition; 		// Staff Position 
	private String srfid;			// Staff RFID 
	
	private boolean valid;
/**
 * @author USER
 *
 */
	public Attendance() {
		super();
	}	

	//.......................   ATTENDANCE DATABASE DECLARATIONN   ........................//
	
	public Attendance(int aid, int staffid, int adminid, float btemp,String checkin, String checkout, String adate) {
		
		super();
		this.aid 		= aid;
		this.staffid 	= staffid;
		this.adminid 	= adminid;
		this.btemp 		= btemp;
		this.checkin 	= checkin;
		this.checkin 	= checkin;
		this.adate 		= adate;

	}
	
	//.......................   ATTENDANCE GET FUNCTION   ........................//
	
	public int getAid() {
		return aid;
	}
	
	public int getStaffid() {
		return staffid;
	}
	
	public int getAdminid() {
		return adminid;
	}

	public float getBtemp() {
		return btemp;
	}
	
	public String getCheckin() {
		return checkin;
	}

	public String getCheckout() {
		return checkout;
	}
	
	public String getAdate() {
		return adate;
	}
	
	public String getSname() {
		return sname;
	}
	
	public String getSdepartment() {
		return sdepartment;
	}
	
	public String getSposition() {
		return sposition;
	}
	
	public String getSrfid() {
		return srfid;
	}
	
	//.......................   STAFF SET FUNCTION   ........................//
	
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	public void setBtemp(float btemp) {
		this.btemp = btemp;
	}
	
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	public void setAdate(String adate) {
		this.adate = adate;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public void setSposition(String sposition) {
		this.sposition = sposition;
	}
	
	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}
	
	public void setSrfid(String srfid) {
		this.srfid = srfid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
