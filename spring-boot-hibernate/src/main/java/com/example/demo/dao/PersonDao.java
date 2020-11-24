package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Person;

@Repository
@Transactional
public class PersonDao {

	@Autowired
	private SessionFactory factory;

	public void savePerson(Person person) {
		getSession().save(person);
	}
	
	public void updatePerson(Person person) {
		getSession().update(person);
	}
	
	public Person findById(int id) {
        // TODO Auto-generated method stub
        //Session session = sessionFactory.getCurrentSession();
        Person person=(Person) getSession().get(Person.class,id);
        return person;
    }

	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return getSession().createCriteria(Person.class).list();
	}

	private Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

	public void deletePersonById(int id) {
		Person person = findById(id);
		
		getSession().delete(person);
		
	}

}
