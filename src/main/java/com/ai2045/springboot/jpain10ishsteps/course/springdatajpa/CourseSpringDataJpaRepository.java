package com.ai2045.springboot.jpain10ishsteps.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai2045.springboot.jpain10ishsteps.course.Course;

/**
 * warum interface und nicht class?
 * When you're making use of Spring Data JPA, you're making use of an interface 
 * 
 * warum extends from interface JpaRepository: you need to extend a specific interface
 * called JPA repository.
 * 
 * <T, ID> wird zu: <Course, Long>
 * T: whats entity does it manage => course
 * ID: whats the type of the id field => long
 * 
 * @author ai1045
 *
 */
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	
	/**
	 * Spring Data JPA: you don't need to talk to the entity manager at all.
	 * 
	 * all that you need to do is to define the entities and write a
	 * repository interface extending JpaRepository with the entity(type) and the ID.
	 * thats it.
	 * => a lot of wonderful methods are exposed to you. (count, save findAll, findById...)
	 * save: used to either update an entity or insert an entity.
	 * count: number of entities which are available.
	 * ...
	 * 
	 * 	=> with Spring Data JPA, you need to write even lesser code.
	 */
	


}
