/**
 * 
 */
/**
VARCHAR2 * @author USER
 *
 */
package scasa.model;

import scasa.model.Staff;

public class Staff {
	private int staffid; 		// Staff ID
	//private int adminid; 		// Admin ID
	//private String role;  			// Staff Category / Role  Staff @ Admin
	private String sname; 			// Staff Name 
	private String sgender; 		// Staff Gender 
	private long   snotel; 			// Staff Tel 
	private String semail;   		// Staff Email 
	private String sdepartment; 	// Staff Department 
	private String sposition; 		// Staff Position 
	private String srfid; 			// Staff RFID
	private long   snric;
	private Staff  srfids;
	private String sstatus; 		// Staff Status 
	private String sstartdate; 		// Staff Start Date 
	//private String spassword; 	// Staff Password 
	private boolean valid;

	public Staff() {
		super();
	}
	
	//.......................   STAFF DATABASE DECLARATIONN   ........................//
	
	public Staff(int staffid,/*int adminid,String role,*/ String sname, String sgender, long snotel,String semail,
			String sdepartment, String sposition, long snric, String srfid,String sstatus,String sstartdate/*, String spassword*/) {
		super();
		this.staffid 	= staffid;
		//this.adminid 	= adminid;
		//this.role 		= role;
		this.sname 		= sname;
		this.sgender 	= sgender;
		this.snotel 	= snotel;
		this.semail 	= semail;
		this.sdepartment= sdepartment;
		this.sposition 	= sposition;
		this.snric	 	= snric;		
		this.srfid 		= srfid;
		this.sstatus 	= sstatus;
		this.sstartdate = sstartdate;
		//this.spassword 	= spassword;
	}
	
	//.......................   STAFF DATABASE DECLARATIONN (WITHOUT STAFF ID)  ........................//
	
	public Staff( String sname, String sgender, long snotel,String semail, String sdepartment, String sposition, long snric, 
			String srfid,String sstatus,String sstartdate/*, String spassword*/) {
		super();

		//this.adminid 	= adminid;
		//this.role 	= role;
		this.sname 		= sname;
		this.sgender 	= sgender;
		this.snotel 	= snotel;
		this.semail 	= semail;
		this.sdepartment= sdepartment;
		this.sposition 	= sposition;
		this.snric	 	= snric;		
		this.srfid 		= srfid;
		this.sstatus 	= sstatus;
		this.sstartdate = sstartdate;
		//this.spassword 	= spassword;
	}

	//.......................   STAFF GET FUNCTION   ........................//

	public int getStaffid() {
		return staffid;
	}
	
	/*public int getAdminid() {
		return adminid;
	}*/

	/*public String getRole() {
		return role;
	}*/

	public String getSname() {
		return sname;
	}
	
	public String getSgender() {
		return sgender;
	}

	public long getSnotel() {
		return snotel;
	}
	
	public String getSemail() {
		return semail;
	}
	
	public String getSdepartment() {
		return sdepartment;
	}
	
	public String getSposition() {
		return sposition;
	}
	
	public long getSnric() {
		return snric;
	}
	
	public String getSrfid() {
		return srfid;
	}
	
	public Staff getSrfids() {
		return srfids;
	}
	
	public String getSstatus() {
		return sstatus;
	}
	
	public String getSstartdate() {
		return sstartdate;
	}
	
	/*public String getSpassword() {
		return spassword;
	}*/
	
	public boolean isValid() {
		return valid;
	}
	
	//.......................   STAFF SET FUNCTION   ........................//
	
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	
	/*public void setAdminid(String adminid) {
		this.adminid = adminid;
	}*/
	
	/*public void setRole(String role) {
		this.role = role;
	}*/
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	
	public void setSnotel(long snotel) {
		this.snotel = snotel;
	}
	
	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}
	
	public void setSposition(String sposition) {
		this.sposition = sposition;
	}
	
	public void setSnric(long snric) {
		this.snric = snric;
	}
	
	public void setSrfid(String srfid) {
		this.srfid = srfid;
	}
	
	public void setSrfids(Staff srfids) {
		this.srfids = srfids;
	}
	
	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}
	
	public void setSstartdate(String sstartdate) {
		this.sstartdate = sstartdate;
	}
	
	/*public void setSpassword(String spassword) {
		this.spassword = spassword;
	}*/	
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}