package com.sjsu.cmpe202.search.retail.listing.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import com.ibm.db2.cmx.annotation.Table;

/* 
 * Yathukulan Thayabaran
 */


@Table(name= "BUYERAPPLICATION", schema = "TRZ79994")
@Entity
public class BuyerApplication {

	 
	@javax.persistence.Id
	//@GeneratedValue	
	private long buyerapplicationid;
	private long propertyid;
	private long buyerapplicantid;
	private String applicationstatus;
	private String supportingdocumentslink;
	private long offerprice;
	
	/*
	 * buyerapplicationid
	 */
	
	public long getBuyerapplicationid() {
		return buyerapplicationid;
	}

	public void setBuyerapplicationid(long buyerapplicationid) {
		this.buyerapplicationid = buyerapplicationid;
	}
	
	/*
	 * propertyid
	 */
	
	public long getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}
	
	/*
	 * buyerapplicantid
	 */
	
	public long getBuyerapplicantid() {
		return buyerapplicantid;
	}

	public void setBuyerapplicantid(long buyerapplicantid) {
		this.buyerapplicantid = buyerapplicantid;
	}
	
	/*
	 * applicationstatus
	 */
	
	public String getApplicationstatus() {
		return applicationstatus;
	}

	public void setApplicationstatus(String applicationstatus) {
		this.applicationstatus = applicationstatus;
	}
	
	/*
	 * supportingdocumentslink
	 */
	
	public String getSupportingdocumentslink() {
		return supportingdocumentslink;
	}

	public void setSupportingdocumentslink(String supportingdocumentslink) {
		this.supportingdocumentslink = supportingdocumentslink;
	}
	
	/*
	 * offerprice
	 */
	
	public long getOfferprice() {
		return offerprice;
	}

	public void setOfferprice(long offerprice) {
		this.offerprice = offerprice;
	}
}
