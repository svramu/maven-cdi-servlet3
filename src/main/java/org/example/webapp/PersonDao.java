package org.example.webapp;

import java.util.List;

//http://tutorials.jenkov.com/java-persistence/dao-design-pattern.html
public interface PersonDao {

  public List<Person> select();
  public Person select(Integer id);
	public int insert(Person person);
  public void update(Integer id, Person person);
  public void delete(Integer id);
  
}
