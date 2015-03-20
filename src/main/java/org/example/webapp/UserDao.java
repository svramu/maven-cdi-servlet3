package org.example.webapp;

import java.util.List;

import org.apache.ibatis.annotations.Select;


public interface UserDao {
	@Select("SELECT DISTINCT(title) AS name FROM titles")
	List<Title> getTitles();
} 

