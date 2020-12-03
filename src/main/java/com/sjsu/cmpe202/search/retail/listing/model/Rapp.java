package com.sjsu.cmpe202.search.retail.listing.model;

import javax.persistence.Entity;
import com.ibm.db2.cmx.annotation.Table;
/*
 * Yathukulan
 */

//renter application
@Table(name= "RAPP", schema = "TRZ79994")
@Entity
public class Rapp {

	@javax.persistence.Id
	//@GeneratedValue
	private long rappid;
	private long propertyid;
	private long renterapplicantid;
	private String rappstatus;
	private String supportingdocumentslink;
	private long applicantcreditscore;
	private long applicantemployment;
	
	public long getRappid() {
		return rappid;
	}
	public void setRappid(long rappid) {
		this.rappid = rappid;
	}
	public long getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}
	public long getRenterapplicantid() {
		return renterapplicantid;
	}
	public void setRenterapplicantid(long renterapplicantid) {
		this.renterapplicantid = renterapplicantid;
	}
	public String getRappstatus() {
		return rappstatus;
	}
	public void setRappstatus(String rappstatus) {
		this.rappstatus = rappstatus;
	}
	public String getSupportingdocumentslink() {
		return supportingdocumentslink;
	}
	public void setSupportingdocumentslink(String supportingdocumentslink) {
		this.supportingdocumentslink = supportingdocumentslink;
	}
	public long getApplicantcreditscore() {
		return applicantcreditscore;
	}
	public void setApplicantcreditscore(long applicantcreditscore) {
		this.applicantcreditscore = applicantcreditscore;
	}
	public long getApplicantemployment() {
		return applicantemployment;
	}
	public void setApplicantemployment(long applicantemployment) {
		this.applicantemployment = applicantemployment;
	}
	


}
