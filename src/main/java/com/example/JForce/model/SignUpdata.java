package com.example.JForce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class SignUpdata {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id", unique = true, nullable = false)
	  private int id;
	  
	  @Column(name = "emailaddress", unique = true, nullable = false)
	  @JsonProperty("emailaddress")
	  private String emailaddress;
	  
	  @Column(name = "firstname", nullable = false )
	  @JsonProperty("firstname")
	  private String firstname;
	  
	  @Column(name = "lastName", nullable = true )
	  @JsonProperty("lastName")
	  private String lastName;
	  
	  @Column(name = "password",nullable = false )
	  @JsonProperty("password")
	  private String password;
	  
	  
	  @Column
	  @JsonProperty
	  private Boolean adminFlag;
	
	  
	  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Boolean getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(Boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	
	  
	 
	  public String getUserName() {
		  return emailaddress;
	  }
	  
	  public String setUserName(String name ) {
		  return emailaddress = name;
	  }

	  
	  
		public String getFirstName() {
			return firstname;
		}
	
		public void setFirstName(String firstname) {
			this.firstname = firstname;
		}
	
		public String getLastName() {
			return lastName;
		}
	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
		public String getPassword() {
			return password;
		}
	
		public void setPassword(String password) {
			this.password = password;
		}
}

