package com.klu.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project implements Serializable{
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int projectID;
String Email;
String ptitle;
String pdescription;
String status="Pending";
String approvedby;
public String getApprovedby() {
	return approvedby;
}
public void setApprovedby(String approvedby) {
	this.approvedby = approvedby;
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
}
