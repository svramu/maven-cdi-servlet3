package org.example.webapp;

import javax.persistance.Entity;

@Entity
public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
  private String username;
	private String passhash;

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  	
  public String getPasshash() {
    return passhash;
  }
  
  public void setPasshash(String passhash) {
    this.passhash = passhash;
  }
  
  
	@Override
	public String toString() {
	  return ""+id+" : "+username+" - "+passhash;
	}
}
