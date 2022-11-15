package com.ai2045.springboot.jpain10ishsteps.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // something which would "talk" to a db
public class CourseJdbcRepository {

	/**
	 * the thing which enables you to fire queries
	 * 
	 * using SpringJdbc is JdbcTemplate.
	 */
	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = """
				insert into course (id, name, author)
				values(1, 'learn ai', 'ai2045')
			""";

	private static String DELETE_QUERY = """
			delete from course where id = ?
			""";

	private static final String INSERT_QUERY_PARAMETERIZED = """
				insert into course (id, name, author)
				values(?, ?, ?)
			""";

	/**
	 * the thing which enables you to fire this insert query when the application
	 * starts up is the CommandLineRunner
	 */
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY_PARAMETERIZED, course.getId(), 
				course.getName(), course.getAuthor());
	}

	public void deleteTask(int id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
}
