package com.klu.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.klu.entity.Project;
import com.klu.model.ProjectActions;
import java.util.*;
@ManagedBean(name="project",eager=true)
public class ProjectBean {
String sname;
int projectID;
String Email;
String ptitle;
String pdescription;
String status;
String response;
List<Project> list;
public List<Project> getList() {
	return list;
}
public void setList(List<Project> list) {
	this.list = list;
}
public ProjectActions getPb() {
	return pb;
}
public void setPb(ProjectActions pb) {
	this.pb = pb;
}
@EJB(lookup="java:global/PROJECT_MANAGEMENT_SYSTEM/ProjectImpl!com.klu.model.ProjectActions")
ProjectActions pb;
public String getResponse() {
	return response;
}
public void setResponse(String response) {
	this.response = response;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public int getProjectID() {
	return projectID;
}
public void setProjectID(int projectID) {
	this.projectID = projectID;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPtitle() {
	return ptitle;
}
public void setPtitle(String ptitle) {
	this.ptitle = ptitle;
}
public String getPdescription() {
	return pdescription;
}
public void setPdescription(String pdescription) {
	this.pdescription = pdescription;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public void dodo()
{
	FacesContext context = FacesContext.getCurrentInstance();
    ExternalContext externalContext = context.getExternalContext();
    String paramValue = externalContext.getRequestParameterMap().get("aa");
    System.out.println(paramValue);
    Email=paramValue;
}
public List<Project> displayProjects()
{
	list=pb.getProjectDetails(Email);
	return list;
}
}
