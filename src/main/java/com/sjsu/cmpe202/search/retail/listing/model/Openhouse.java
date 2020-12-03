package com.sjsu.cmpe202.search.retail.listing.model;

import javax.persistence.Entity;
import com.ibm.db2.cmx.annotation.Table;

import java.sql.Date;
/*
 * Yathukulan
 */
//renter application
@Table(name= "OPENHOUSE", schema = "TRZ79994")
@Entity
public class Openhouse {

	@javax.persistence.Id
	//@GeneratedValue
	private long openhouseid;
	private long propertyid;
	private long visitorid;
	private Date fromdatetime;
	private Date todatetime;
	
	public long getOpenhouseid() {
		return openhouseid;
	}
	public void setOpenhouseid(long openhouseid) {
		this.openhouseid = openhouseid;
	}
	public long getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}
	public long getVisitorid() {
		return visitorid;
	}
	public void setVisitorid(long visitorid) {
		this.visitorid = visitorid;
	}
	public Date getFromdatetime() {
		return fromdatetime;
	}
	public void setFromdatetime(Date fromdatetime) {
		this.fromdatetime = fromdatetime;
	}
	public Date getTodatetime() {
		return todatetime;
	}
	public void setTodatetime(Date todatetime) {
		this.todatetime = todatetime;
	}
	
}
