package com.fil.easemystay.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fil.easemystay.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	private String admin_name;
	private String admin_email;
	private String admin_mobile;


	@JsonProperty(access = Access.WRITE_ONLY)
	private String admin_password;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private Role role;
	
	

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return admin_name;
	}

	public void setName(String name) {
		this.admin_name = name;
	}

	public String getEmail() {
		return admin_email;
	}

	public void setEmail(String email) {
		this.admin_email = email;
	}

	public String getMobile() {
		return admin_mobile;
	}

	public void setMobile(String mobile) {
		this.admin_mobile = mobile;
	}

	public String getPassword() {
		return admin_password;
	}

	public void setPassword(String password) {
		this.admin_password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

	public Admin(String admin_name, String admin_email, String admin_mobile, String admin_password, Role role) {
		super();
		this.admin_name = admin_name;
		this.admin_email = admin_email;
		this.admin_mobile = admin_mobile;
		this.admin_password = admin_password;
		this.role = role;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}