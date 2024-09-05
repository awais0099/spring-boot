package com.example.socialmediaapprestapi.versioning;

public class PersonV2 {
	private String fname;
	private String lname;
	
	public PersonV2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonV2(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "PersonV2 [fname=" + fname + ", lname=" + lname + "]";
	}
}
