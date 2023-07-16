package com.sddo.dv1c02.cw1.dto;

public class User {

	private String userID;
	private String password;
	private String name;
	private String email;
	private String officeTel;
	private String mobileTel;
	private String role;
    
	/**
	 * @param userID
	 * @param password
	 * @param name
	 * @param email
	 * @param officeTel
	 * @param mobileTel
	 * @param role
	 */
	public User(String userID, String password, String name, String email, String officeTel, String mobileTel,
			String role) {
		super();
		this.userID = userID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.officeTel = officeTel;
		this.mobileTel = mobileTel;
		this.role = role;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public String getMobileTel() {
		return mobileTel;
	}
	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
    
}
