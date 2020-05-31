package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    return registration;
	}
	@Override
	public void run(String... arg0) throws Exception {
		 logger.info("All users ---> {}", dao.findAll());
		 
		 logger.info("UserId 10001 ---> {}", dao.findById(10001));
		 
		 logger.info("Deleting 10002 ---> No of rows deleted{}",
				 dao.deleteById(10002));

		 logger.info("Inserting 10005 ---> {}", 
				 dao.insert(new Person(10005, "Tara", "Mangalore", new Date())));

		 logger.info("Updating 10003 ---> {}", 
				 dao.update(new Person(10003, "Sheethal", "Harihar", new Date())));

	}
}
