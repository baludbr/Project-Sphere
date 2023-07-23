package com.klu.model;

import javax.ejb.Remote;

import com.klu.entity.ContactUs;
@Remote
public interface QueryActions {
	public String addQuery(ContactUs c);
}
