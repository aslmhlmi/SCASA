package scasa.model;

public class Api {
	
	private String  rfid; 		// RFID ID
	private float	temp;	 	// TEMPERATURE ID
	
	public Api() {
//		super();
	}
	
	//.......................   API DATABASE DECLARATIONN   ........................//
	
	public Api(String rfid, float temp) {
//		super();
		this.rfid = rfid;
		this.temp = temp;
	}
	
	//.......................   API GET FUNCTION   ........................//

	
	public String getRfid() {
		return rfid;
	}
	
	public float getTemp() {
		return temp;
	}
	
	//.......................   API SET FUNCTION   ........................//
	

		public void setRfid(String rfid) {
			this.rfid = rfid;
		}
		
		public void setTemp(float temp) {
			this.temp = temp;
		}
}
