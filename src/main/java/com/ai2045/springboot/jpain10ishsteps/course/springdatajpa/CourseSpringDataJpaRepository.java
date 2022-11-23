package com.ai2045.springboot.jpain10ishsteps.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai2045.springboot.jpain10ishsteps.course.Course;

/**
 * warum interface und nicht class? When you're making use of Spring Data JPA,
 * you're making use of an interface
 * 
 * warum extends from interface JpaRepository: you need to extend a specific
 * interface called JPA repository.
 * 
 * <T, ID> wird zu: <Course, Long> T: whats entity does it manage => course ID:
 * whats the type of the id field => long
 * 
 * @author ai1045
 *
 */
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	/**
	 * Spring Data JPA: you don't need to talk to the entity manager at all.
	 * 
	 * all that you need to do is to define the entities and write a repository
	 * interface extending JpaRepository with the entity(type) and the ID. thats it.
	 * => a lot of wonderful methods are exposed to you. (count, save findAll,
	 * findById...) save: used to either update an entity or insert an entity.
	 * count: number of entities which are available. ...
	 * 
	 * => with Spring Data JPA, you need to write even lesser code.
	 */

	// with Spring Data JPA Repository able to add custom methods:
	// zb search by author.
	//
	// => you need to follow a NAMING CONVENTION:
	// findBy followed by the attribute name in the class. (a groß)
	//
	// => findByAuthor

	// inputparameter: author (das attribut selbst, nach dem gesucht wird)
	// => findByAuthor(String author)

	// neyi return? List of Courses
	// =>
	// List<Course> findByAuthor(String author)

	// so, dann gehst du einfach her in commandlinerunner und sagst zb:

	// System.out.println(repo.findByAuthor("HU"));

	// UND ER FINDET DAS!!! (er macht das einfach!)

	// => OHNE DASS ICH CODE DAFÜR GESCHRIEBEN HABE (keine methodendeklaration (interface))

	//	=> funktioniert über namenskonvention

	List<Course> findByAuthor(String author);  // dh suche nach Attribut author
	List<Course> findByName(String name);  // dh suche nach Attribut name

	

}
