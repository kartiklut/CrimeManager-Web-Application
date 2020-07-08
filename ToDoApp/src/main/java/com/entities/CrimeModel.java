package com.entities;

import java.util.Date;

public class CrimeModel {

	private Date date;
	private String crimeTitle;
	private String crimeContent;
	public CrimeModel(Date date, String crimeTitle, String crimeContent) {
		super();
		this.date = date;
		this.crimeTitle = crimeTitle;
		this.crimeContent = crimeContent;
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
		return "CrimeModel [date=" + date + ", crimeTitle=" + crimeTitle + ", crimeContent=" + crimeContent + "]";
	}
	
	
	
	
}
