package com.in28minutes.database.databasedemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	// by ID 
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?",new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	// deleteById
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?",new Object[] {id});
	}
	
	//insert
	public int insert(Person person) {
		System.out.println("perosn.id>>>>>>>>."+ person.getId());
		return jdbcTemplate.update(
				"insert into person(id, name, location, birth_Date)"
				+ "values(?, ?, ?, ?)",
				 new Object[]{
						 person.getId(), person.getName(),
						 person.getLocation(),
						 new Timestamp(person.getBirthdate().getTime())
						 });
	}
	
	//update
	public int update(Person person) {
		return jdbcTemplate.update(
				"update person "
				+ " set name = ?, location = ?, birth_Date = ? "
				+ " where id = ?",
				 new Object[]{
						 person.getName(),
						 person.getLocation(),
						 new Timestamp(person.getBirthdate().getTime()),
						 person.getId()});
	}
}