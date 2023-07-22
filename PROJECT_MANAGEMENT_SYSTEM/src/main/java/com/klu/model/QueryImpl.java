package com.klu.model;

import javax.persistence.EntityManagerFactory;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;

import com.klu.entity.ContactUs;
@Stateless
@TransactionManagement(value=TransactionManagementType.BEAN)
public class QueryImpl implements QueryActions{

	@Override
	public String addQuery(ContactUs c) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pms");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Thank you for your request!!We will contact you soon";
	}

}
