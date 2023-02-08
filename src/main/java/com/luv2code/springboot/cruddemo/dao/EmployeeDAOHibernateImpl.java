package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection 
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		theEntityManager=entityManager;
		
	}
	

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// get current Hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create a query
		Query <Employee>theQuery=
				currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee>employee=theQuery.getResultList();
		
		//return result
		return employee;
	}

}
