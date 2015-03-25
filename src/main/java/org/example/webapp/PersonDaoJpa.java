package org.example.webapp;

import java.util.*;
import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.ejb.Stateless;

import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.*;

public class PersonDaoJpa implements PersonDao {

  //@PersistenceContext(unitName="mainpu")
  //@Inject
  EntityManager em;
  
  public List<Person> select() {
    try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Person> query = cb.createQuery(Person.class);
			Root<Person> person = query.from(Person.class);
			query.select(person);
			return em.createQuery(query).getResultList();
				
		} catch (NoResultException nre) {
			nre.printStackTrace();
			System.out.println("No Result was found");
			return null;
			
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			System.out.println("Ejb Exception occured");
			return null;
		}  
		//won't come here!?
	}
  
  public Person select(Integer id) {
    return em.find(Person.class, id);
  }
  
	public int insert(Person person) {
    em.persist(person);
		em.flush();
	  return 1729;//TBD: Get the inserted id
	}  

  public void update(Integer id, Person person) {
    Person _person = em.find(Person.class, id);
		_person.setUsername(person.getUsername());
		em.persist(_person);
		em.flush();
	}
  
  public void delete(Integer id) {
    Person person = em.find(Person.class, id);
		em.remove(person);	
  }
}
