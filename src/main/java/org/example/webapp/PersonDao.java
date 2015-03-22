package org.example.webapp;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import org.apache.ibatis.annotations.Options;


public interface PersonDao {
	@Select("SELECT id, username FROM person")
	List<Person> select() throws Exception;
	
	@Select("SELECT id, username FROM person WHERE id = #{0}")
	Person select1(int id) throws Exception;

	@Select("SELECT id, username FROM person WHERE username = '#{0}'")
	Person select2(String username) throws Exception;

//	@Insert("INSERT person (id, username, passhash, salt) VALUES  (0, #{0}, #{1}, 'dummy')")
//	@Options(useGeneratedKeys = true, keyProperty = "id")
//	int insert(String username, String passhash) throws Exception;

	@Update("UPDATE person SET passhash = '#{0}' WHERE username = '#{1}'")
	int update(String username, String passhash) throws Exception;

	@Delete("DELETE FROM person WHERE id = #{0}")
	int delete(int id) throws Exception;

	@Delete("DELETE FROM person WHERE username = '#{0}'")
	int delete1(String username) throws Exception;
} 

