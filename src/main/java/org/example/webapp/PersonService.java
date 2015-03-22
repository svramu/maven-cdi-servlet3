package org.example.webapp;

import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
//import javax.persistence.*;

import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.*;

@ApplicationScoped
@Path("/person")
public class PersonService {
  //@PersistenceContext
  //private EntityManager em;
  
  private List<Person> list = new ArrayList<>(); 

  public PersonService() {
    list.add(new Person(0, "Dummy Person 0", "secrethash"));
    list.add(new Person(1, "Dummy Person 1", "secrethash"));
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Person> select() {
    return list;
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Person select(@PathParam("id") int id) {
    return list.get(id);
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
	public int insert(Person person) {
	  person.setId(list.size());
	  return list.add(person)? list.size()-1: -1; 
	}  

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public void update(@PathParam("id") int id, Person person) {
    list.get(id).setUsername(person.getUsername());
  }
  
  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Person delete(@PathParam("id") int id) {
    return list.remove(id);
  }
}
