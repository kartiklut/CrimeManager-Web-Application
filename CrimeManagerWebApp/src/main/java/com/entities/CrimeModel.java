package com.entities;

import java.util.Date;

public class CrimeModel {

	private Date date;
	private String crimeTitle;
	private String crimeContent;
	private String index;
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public CrimeModel(Date date, String crimeTitle, String crimeContent, String index) {
		super();
		this.date = date;
		this.crimeTitle = crimeTitle;
		this.crimeContent = crimeContent;
		this.index = index;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCrimeTitle() {
		return crimeTitle;
	}
	public void setCrimeTitle(String crimeTitle) {
		this.crimeTitle = crimeTitle;
	}
	public String getCrimeContent() {
		return crimeContent;
	}
	public void setCrimeContent(String crimeContent) {
		this.crimeContent = crimeContent;
	}
	public CrimeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CrimeModel [date=" + date + ", crimeTitle=" + crimeTitle + ", crimeContent=" + crimeContent + ", index="
				+ index + "]";
	}
	
	
	
	
}
