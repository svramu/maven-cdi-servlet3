package org.example.webapp;

import java.util.List;
import java.util.ArrayList;
import javax.enterprise.inject.Alternative;

//http://docs.oracle.com/javaee/6/tutorial/doc/gjsdf.html
@Alternative
public class PersonDaoDummy implements PersonDao {

  private List<Person> list = new ArrayList<>(); 

  public PersonDaoDummy() {
    list.add(new Person(0, "Dummy Person 0", "secrethash"));
    list.add(new Person(1, "Dummy Person 1", "secrethash"));
  }

  public List<Person> select() {
    return list;
  }
  
  public Person select(Integer id) {
    return list.get(id);
  }
  
	public int insert(Person person) {
	  person.setId(list.size());
	  return list.add(person)? list.size()-1: -1; 
	}  

  public void update(Integer id, Person person) {
    list.get(id).setUsername(person.getUsername());
  }
  
  public void delete(Integer id) {
    list.remove((int)id);
  }
}
