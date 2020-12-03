package com.sjsu.cmpe202.search.retail.listing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/*
 * Author: Atanu Ghosh
 */

@Entity
public class Favorite {

	@javax.persistence.Id
	@GeneratedValue	
	private long userfavid;
	private int userid;
	private int propertyid;
	
	public long getUserfavid() {
		return userfavid;
	}
	public void setUserfavid(long userfavid) {
		this.userfavid = userfavid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	
}
