package com.example.kitanoskan.json.Models;

public class JtoAddressDetails {
	
	protected String address = null;
	protected String streetNumber = null;
	protected String postcode = null;
	protected String city = null;
	protected String province = null;
	protected String nationCode = null;
	protected String nationDescr = null;
	
	
	
	
	public JtoAddressDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	public JtoAddressDetails(String address, String streetNumber,
			String postcode, String city, String province, String nationCode,
			String nationDescr) {
		super();
		this.address = address;
		this.streetNumber = streetNumber;
		this.postcode = postcode;
		this.city = city;
		this.province = province;
		this.nationCode = nationCode;
		this.nationDescr = nationDescr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getNationCode() {
		return nationCode;
	}
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}
	public String getNationDescr() {
		return nationDescr;
	}
	public void setNationDescr(String nationDescr) {
		this.nationDescr = nationDescr;
	}
	
	
	

}
