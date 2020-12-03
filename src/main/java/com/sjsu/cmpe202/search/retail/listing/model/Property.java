package com.sjsu.cmpe202.search.retail.listing.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/*
 * Author: Atanu Ghosh
 */

@Entity
public class Property { 
	 
	@javax.persistence.Id
	@GeneratedValue	
	private long propertyid;
	private String parkingtype;
	private String hometype;
	private String floortype;
	private int numberofbathrooms;
	private int numberofbedrooms;
	private int sqft;
	private int yearbuild;
	private int price;
	private String streetname;
	private String city;
	private String state;
	private int zipcode;
	private String otheramenities;
	private String ownerid;
	private String realtorid;
	private String buyorrent;
	private String leaseterms;
	private Date availabilitydate;
	private int securitydeposit;
	private String active;
	private String imageurl;
	
	public long getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}
	public String getParkingtype() {
		return parkingtype;
	}
	public void setParkingtype(String parkingtype) {
		this.parkingtype = parkingtype;
	}
	public String getHometype() {
		return hometype;
	}
	public void setHometype(String hometype) {
		this.hometype = hometype;
	}
	public String getFloortype() {
		return floortype;
	}
	public void setFloortype(String floortype) {
		this.floortype = floortype;
	}
	public int getNumberofbathrooms() {
		return numberofbathrooms;
	}
	public void setNumberofbathrooms(int numberofbathrooms) {
		this.numberofbathrooms = numberofbathrooms;
	}
	public int getNumberofbedrooms() {
		return numberofbedrooms;
	}
	public void setNumberofbedrooms(int numberofbedrooms) {
		this.numberofbedrooms = numberofbedrooms;
	}
	public int getSqft() {
		return sqft;
	}
	public void setSqft(int sqft) {
		this.sqft = sqft;
	}
	public int getYearbuild() {
		return yearbuild;
	}
	public void setYearbuild(int yearbuild) {
		this.yearbuild = yearbuild;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getOtheramenities() {
		return otheramenities;
	}
	public void setOtheramenities(String otheramenities) {
		this.otheramenities = otheramenities;
	}
	public String getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}
	public String getRealtorid() {
		return realtorid;
	}
	public void setRealtorid(String realtorid) {
		this.realtorid = realtorid;
	}
	public String getBuyorrent() {
		return buyorrent;
	}
	public void setBuyorrent(String buyorrent) {
		this.buyorrent = buyorrent;
	}
	public String getLeaseterms() {
		return leaseterms;
	}
	public void setLeaseterms(String leaseterms) {
		this.leaseterms = leaseterms;
	}
	public Date getAvailabilitydate() {
		return availabilitydate;
	}
	public void setAvailabilitydate(Date availabilitydate) {
		this.availabilitydate = availabilitydate;
	}
	public int getSecuritydeposit() {
		return securitydeposit;
	}
	public void setSecuritydeposit(int securitydeposit) {
		this.securitydeposit = securitydeposit;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	
}
