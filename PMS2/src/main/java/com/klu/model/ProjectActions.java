package com.klu.model;

import java.sql.ResultSet;
import java.util.List;

import javax.ejb.Remote;

import com.klu.entity.Project;
import com.klu.entity.User;

@Remote
public interface ProjectActions {
	public String addProject(Project p);
	public List<Project> getProjectDetails(String Email);
	public List<Project> getAllProjectDetails();
	public String approveProject(Project p);
	public List<Project> getAllApprovedProjectDetails(String Email);
}
