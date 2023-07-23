package com.klu.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.klu.entity.ContactUs;
import com.klu.model.QueryActions;

@ManagedBean(name="query",eager=true)
public class QueryBean {
	int id;
	String fname;
	String lname;
	String mail;
	String phonenum;
	String msg;
	String response;
	@EJB(lookup="java:global/PROJECT_MANAGEMENT_SYSTEM/QueryImpl!com.klu.model.QueryActions")
	QueryActions qr;
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void AddQuery()
	{
		ContactUs p=new ContactUs();
		p.setId(id);
		p.setFname(fname);
		p.setLname(lname);
		p.setPhonenum(phonenum);
		p.setMail(mail);
		p.setMsg(msg);
		response=qr.addQuery(p);
	}
}
