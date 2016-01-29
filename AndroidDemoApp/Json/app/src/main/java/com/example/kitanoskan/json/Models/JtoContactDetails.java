package com.example.kitanoskan.json.Models;

public class JtoContactDetails {
	
	protected String email = null;
	protected String landLine = null;
	protected String fax = null;
	protected String mobile = null;
	
	
	public JtoContactDetails() {
		// TODO Auto-generated constructor stub
	}
	
		
	public JtoContactDetails(String email, String landLine, String fax,
			String mobile) {
		super();
		this.email = email;
		this.landLine = landLine;
		this.fax = fax;
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLandLine() {
		return landLine;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}
