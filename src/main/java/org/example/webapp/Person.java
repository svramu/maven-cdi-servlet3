package org.example.webapp;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
  private String username;
	private String passhash;

  public Person() {}

  public Person(Integer id, String username, String passhash) {
    this.id = id;
    this.username = username;
    this.passhash = passhash;
  }

  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
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
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }
 
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Person)) {
        return false;
    }
    Person other = (Person) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
        return false;
    }
    return true;
  }  

	@Override
	public String toString() {
	  return ""+id+" : "+username+" - "+passhash;
	}
}
