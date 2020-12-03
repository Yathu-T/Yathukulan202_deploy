package com.sjsu.cmpe202.search.retail.listing.model;

import javax.persistence.Entity;
import com.ibm.db2.cmx.annotation.Table;

/*
 * Author: Atanu Ghosh
 */


@Table(name= "USER", schema = "TRZ79994")
@Entity
public class User {

	@javax.persistence.Id
	//@GeneratedValue
	private long userid;
	private String email;
	private String firstname;
	private String lastname;
	private String status;
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
