package com.ai2045.springboot.jpain10ishsteps.course.jpa;

import org.springframework.stereotype.Repository;

import com.ai2045.springboot.jpain10ishsteps.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Once we have an entity defined, now we can write a repository to play with
 * this entity. Again, this is something which would talk to a database.
 * 
 * @author ai1045
 *
 */

@Repository
@Transactional
// ohne diese anno runtimeerror: Caused by: jakarta.persistence.TransactionRequiredException:
// No EntityManager with actual transaction available for current thread
// So what it's saying is entity manager does not have transaction.
// So whenever you'd want to execute queries with JPA you need to have a transaction enabled.
// And that's why you need to add in an annotation called @Transactional.
public class CourseJpaRepository {

//	And when you'd want to make use of JPA to talk to the database,
//	you need to make use of something called EntityManager.
//	So we wrote an entity (@Entity) and we will use an entity manager to manage our entity.

	@PersistenceContext // in dem fall besser (spezifischer) als @Autowired: Expresses a dependency on a
	private EntityManager em; // container-managed EntityManager and its associated persistence context.
	// bunlarin aynisini jpa ile yapmak istiyoruz (jdbc'den)
	// yani insert delete select:
//	repo.insert();
//	repo.deleteTask(1);
//	repo.insert(new Course(1, "hay", "hu"));
//	repo.insert(new Course(2, "hay", "hu"));
//	repo.insert(new Course(3, "hay", "hu"));
//	repo.insert(new Course(4, "hay", "hu"));
//	repo.deleteTask(2);
//	repo.deleteTask(4);
//	System.out.println(repo.selectById(1));
//	System.out.println(repo.selectById(3));

	public void insert(Course course) {
		em.merge(course); // thats it
	}

	public Course findById(long id) {
		return em.find(Course.class, id);
	}

	public void deleteById(long id) {
		em.remove(findById(id));
	}

}
