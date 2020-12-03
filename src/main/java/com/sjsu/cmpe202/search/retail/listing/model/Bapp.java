package com.sjsu.cmpe202.search.retail.listing.model;

import javax.persistence.Entity;
import com.ibm.db2.cmx.annotation.Table;

/*
 * Yathukulan
 */
//buyerapplication
@Table(name= "BAPP", schema = "TRZ79994")
@Entity
public class Bapp {

	@javax.persistence.Id
	//@GeneratedValue
	private long bappid;
	private long propertyid;
	private long buyerapplicantid;
	private String bappstatus;
	private String supportingdocumentslink;
	private long offerprice;
	
	/*
	 * buyerapplicationid
	 */
	
	public long getBappid() {
		return bappid;
	}

	public void setBappid(long buyerapplicationid) {
		this.bappid = buyerapplicationid;
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
	
//	/*
//	 * applicationstatus
//	 */
//	
//	public String getApplicationstatus() {
//		return bappstatus;
//	}
//
//	public void setApplicationstatus(String applicationstatus) {
//		this.bappstatus = applicationstatus;
//	}
	
	/*
	 * supportingdocumentslink
	 */
	public String getBappstatus() {
		return bappstatus;
	}

	public void setBappstatus(String bappstatus) {
		this.bappstatus = bappstatus;
	}
	
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
