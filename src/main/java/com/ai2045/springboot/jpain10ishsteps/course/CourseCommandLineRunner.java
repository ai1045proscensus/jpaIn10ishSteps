package com.ai2045.springboot.jpain10ishsteps.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ai2045.springboot.jpain10ishsteps.course.jdbc.CourseJdbcRepository;
import com.ai2045.springboot.jpain10ishsteps.course.jpa.CourseJpaRepository;

/**
 * 
 * @author ai1045 
 * 
 * needed to make insert queries etc run at start up:
 * "When you have some logic to run at the start of a SpringApplication,
 * you can make use of the Command Line Runner."
 * 
 * used for spring jdbc AND jpa
 */
@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private CourseJdbcRepository repo;
	
	@Autowired
	private CourseJpaRepository repo;

	@Override
	/**
	 * executed at start up
	 */
	public void run(String... args) throws Exception {
		//spring jdbc
//		repo.insert();
//		repo.deleteById(1);
		repo.insert(new Course(1, "HAY", "HU"));
		repo.insert(new Course(2, "hay", "hu"));
		repo.insert(new Course(3, "hay", "hu"));
		repo.insert(new Course(4, "hay", "hu"));
		repo.deleteById(2);
		repo.deleteById(4);
		System.out.println(repo.findById(1));
		System.out.println(repo.findById(3));
		
		//jpa
		repo.insert(new Course(5, "hak", "nur"));
		repo.deleteById(3);
		System.out.println(repo.findById(1));
		System.out.println(repo.findById(5));
	}

}
