/**
 * 
 */
package scasa.model;


/**
 * @author USER
 *
 */
public class Profile {
	private int adminid; 		// Admin ID
	private int hodid;	 		// HOD ID	
	private String role;  			// Admin Category / Role  Admin @ Admin
	private String aname; 			// Admin Name 
	private String agender; 		// Admin Gender 
	private String anotel; 			// Admin Tel 
	private String aemail;   		// Admin Email 
	private String adepartment; 	// Admin Department 
	private String aposition; 		// Admin Position
	private String anric;
	private String arfid; 			// Admin RFID 
	private Admin  arfids;
	private String astatus; 		// Admin Status 
	private String astartdate; 		// Admin Start Date 
	private String apassword; 		// Admin Password 
	
	private boolean valid;
	
	public Profile() {
		super();
	}
	
	//.......................   STAFF DATABASE DECLARATIONN   ........................//
	
	public Profile(int adminid, int hodid, String role,String aname, String agender, String anotel,String aemail,
			String adepartment, String aposition, String anric, String arfid,String astatus,String astartdate, String apassword) {
		super();
		this.adminid 	= adminid;
		this.hodid 		= hodid;		
		this.role 		= role;
		this.aname 		= aname;
		this.agender 	= agender;
		this.anotel 	= anotel;
		this.aemail 	= aemail;
		this.adepartment= adepartment;
		this.aposition 	= aposition;
		this.anric 		= anric;
		this.arfid 		= arfid;
		this.astatus 	= astatus;
		this.astartdate = astartdate;
		this.apassword 	= apassword;
		
		}

		//.......................   STAFF GET FUNCTION   ........................//

		
		public int getAdminid() {
			return adminid;
		}

		public int getHodid() {
			return hodid;
		}
		
		public String getRole() {
			return role;
		}

		public String getAname() {
			return aname;
		}
		
		public String getAgender() {
			return agender;
		}

		public String getAnotel() {
			return anotel;
		}
		
		public String getAemail() {
			return aemail;
		}
		
		public String getAdepartment() {
			return adepartment;
		}
		
		public String getAposition() {
			return aposition;
		}
		
		public String getAnric() {
			return anric;
		}
		
		public String getArfid() {
			return arfid;
		}
		
		public Admin getArfids() {
			return arfids;
		}
		
		public String getAstatus() {
			return astatus;
		}
		
		public String getAstartdate() {
			return astartdate;
		}
		
		public String getApassword() {
			return apassword;
		}
		
		public boolean isValid() {
			return valid;
		}
		
		//.......................   STAFF SET FUNCTION   ........................//
		

		public void setAdminid(int adminid) {
			this.adminid = adminid;
		}
		
		public void setHodid(int hodid) {
			this.hodid = hodid;
		}
		
		public void setRole(String role) {
			this.role = role;
		}
		
		public void setAname(String aname) {
			this.aname = aname;
		}
		
		public void setAgender(String agender) {
			this.agender = agender;
		}
		
		public void setAnotel(String anotel) {
			this.anotel = anotel;
		}
		
		public void setAemail(String aemail) {
			this.aemail = aemail;
		}
		
		public void setAdepartment(String adepartment) {
			this.adepartment = adepartment;
		}
		
		public void setAposition(String aposition) {
			this.aposition = aposition;
		}
		
		public void setAnric(String anric) {
			this.anric = anric;
		}
		
		public void setArfid(String arfid) {
			this.arfid = arfid;
		}
		
		public void setArfids(Admin arfids) {
			this.arfids = arfids;
		}
		
		public void setAstatus(String astatus) {
			this.astatus = astatus;
		}
		
		public void setAstartdate(String astartdate) {
			this.astartdate = astartdate;
		}
		
		public void setApassword(String apassword) {
			this.apassword = apassword;
		}
		
		
		
		public void setValid(boolean valid) {
			this.valid = valid;
		}
}
