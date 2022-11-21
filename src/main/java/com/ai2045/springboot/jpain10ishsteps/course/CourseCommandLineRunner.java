package com.ai2045.springboot.jpain10ishsteps.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ai2045.springboot.jpain10ishsteps.course.jpa.CourseJpaRepository;
import com.ai2045.springboot.jpain10ishsteps.course.springdatajdbc.CourseSpringDataJdbcRepository;
import com.ai2045.springboot.jpain10ishsteps.course.springdatajpa.CourseSpringDataJpaRepository;

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
	
//	@Autowired
//	private CourseJpaRepository repo;
	
//	"here we don't want to make use of the JPA repository.
//	What we want to do is to make use of our new thing.
//	We have a new kid on the block":
	
	@Autowired
	private CourseSpringDataJpaRepository repo;

	@Override
	/**
	 * executed at start up
	 */
	public void run(String... args) throws Exception {
		//spring jdbc
//		repo.insert();
//		repo.deleteById(1);
		
//		repo.insert(new Course(1, "HAY", "HU"));
//		repo.insert(new Course(2, "hay", "hu"));
//		repo.insert(new Course(3, "hay", "hu"));
//		repo.insert(new Course(4, "hay", "hu"));
//		repo.deleteById(2);
//		repo.deleteById(4);
//		System.out.println(repo.findById(1));
//		System.out.println(repo.findById(3));
//		
//		//jpa
//		repo.insert(new Course(5, "hak", "nur"));
//		repo.deleteById(3);
//		System.out.println(repo.findById(1));
//		System.out.println(repo.findById(5));
		
		// transition from spring jdbc to springdatajpa:
		// just change insert methods to save:
		repo.save(new Course(1, "HAY", "HU"));
		repo.save(new Course(2, "hay", "hu"));
		repo.save(new Course(3, "hay", "hu"));
		repo.save(new Course(4, "hay", "hu"));
		
		//"The only other change that we would need to do is to change the type.
		// We are passing in integers in here, the method expects long,
		// so I'm adding an L at the end."
		// da wir aber dasselber so definiert haben: ... JpaRepository<Course, Long>
		repo.deleteById(2L);
		repo.deleteById(4l);
		
		System.out.println(repo.findById(1l));
		System.out.println(repo.findById(3l));
	}

}
