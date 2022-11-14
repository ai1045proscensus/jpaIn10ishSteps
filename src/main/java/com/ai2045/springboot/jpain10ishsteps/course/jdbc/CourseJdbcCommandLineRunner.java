package com.ai2045.springboot.jpain10ishsteps.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ai1045 
 * 
 * needed to make insert queries etc run at start up:
 * "When you have some logic to run at the start of a SpringApplication,
 * you can make use of the Command Line Runner."
 */
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJdbcRepository repo;

	@Override
	/**
	 * executed at start up
	 */
	public void run(String... args) throws Exception {
		repo.insert();
	}

}
