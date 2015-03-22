package org.example.webapp;

import java.io.Serializable;

public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

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
