package com.klu.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klu.entity.Project;
import com.klu.entity.User;
@Stateless
@TransactionManagement(value=TransactionManagementType.BEAN)
public class UserImpl implements UserActions{

	@Override
	public String register(User u) {
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("pms");
	     		EntityManager em=emf.createEntityManager();
	        	em.getTransaction().begin();
	        	String jpql = "SELECT u FROM User u WHERE u.email = :email";
	            TypedQuery<User> query = em.createQuery(jpql,User.class);
	            query.setParameter("email", u.getEmail());
	            try
	            {
	            User uu=query.getSingleResult();
	            em.close();
	     		emf.close();
	     		return "Email Already Exists"; 
	            }
	            catch(Exception e)
	            {
	     		em.persist(u);
	     		em.getTransaction().commit();
	     		em.close();
	     		emf.close();
	     		return "Registered Successfully"; 
	            }
		
	}

	@Override
	public String login(User u) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pms");
 		EntityManager em=emf.createEntityManager();
    	em.getTransaction().begin();
    	String jpql = "SELECT u FROM User u WHERE u.email = :email and u.password = :password";
        TypedQuery<User> query = em.createQuery(jpql,User.class);
        query.setParameter("email", u.getEmail());
        query.setParameter("password",u.getPassword());
        try
        {
        	User uu=query.getSingleResult();
            em.close();
     		emf.close();
     		return uu.getRole(); 
        }
        catch(Exception e)
        {
        	em.close();
     		emf.close();
     		return "Invalid Credentials"; 
        }
	}

	@Override
	public List<User> getAllUsers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pms");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT u FROM User u";
        Query query = em.createQuery(jpql,User.class);
        List<User> resultList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return resultList;
	}

}