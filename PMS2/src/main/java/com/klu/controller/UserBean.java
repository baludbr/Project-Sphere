package com.klu.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

import com.klu.entity.User;
import com.klu.model.UserActions;

@ManagedBean(name="user",eager=true)
@SessionScoped

public class UserBean {
int id;
@Size(min=4)
String name;
String email;
@Size(min=8)
String password;
String role;
String response;
@EJB(lookup="java:global/PROJECT_MANAGEMENT_SYSTEM/UserImpl!com.klu.model.UserActions")
UserActions us;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getResponse() {
	return response;
}
public void setResponse(String response) {
	this.response = response;
}
public String register()
{
	User u=new User();
	u.setName(name);
	u.setEmail(email);
	u.setPassword(password);
	u.setRole(role);
	String s=us.register(u);
	if(s.equals("Registered Successfully"))
	{
		return "login.jsf??faces-redirect=true";
	}
	else
	{
		response=s;
		return "register.jsf";
	}
}
public String login()
{
	User u=new User();
	u.setEmail(email);
	u.setPassword(password);
	String s=us.login(u);
	if(s.equalsIgnoreCase("Student")||s.equalsIgnoreCase("Guide")||s.equals("Login Successful")||s.equals("admin"))
	{
		response=s;
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.getSessionMap().put("data",id);
		return "home.jsf";
	}
	else
	{
		response=s;
		return "login.jsf";
	}
}
public List<User> getAllUsers()
{
	return us.getAllUsers();
}
}