package org.example.webapp;

import java.util.*;
import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.container.ResourceContext;

@ApplicationScoped
@Path("/person")
public class PersonService {

  @Inject
  PersonDao personDao;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Person> select() {
    return personDao.select();
	}
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Person select(@PathParam("id") Integer id) {
    return personDao.select(id);
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
	public int insert(Person person) {
    return personDao.insert(person);
	}  

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public void update(@PathParam("id") Integer id, Person person) {
    personDao.update(id, person);
	}
  
  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public void delete(@PathParam("id") Integer id) {
    personDao.delete(id);
  }
  
}

