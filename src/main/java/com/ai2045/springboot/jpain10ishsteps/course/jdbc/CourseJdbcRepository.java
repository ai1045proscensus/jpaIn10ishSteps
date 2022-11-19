package com.ai2045.springboot.jpain10ishsteps.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ai2045.springboot.jpain10ishsteps.course.Course;


/**
 * 
 * @author ai1045
 *
 *
 * Vorteil von spring jdbc: code reduction
 * 
 * mit plain jdbc ca. 20 zeilen code (resultset, try catch, usw...=
 * mit spring jdbc: 1 zeile (s.u.): jdbctemplate.update...
 *
 */

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
	
	private static final String SELECT_QUERY_PARAMETERIZED = """
			select * from  course
			where id = ?
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

	public void deleteById(int id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	/**
	 * ResultSet -> Bean mapping (mithilfe von Rowmapper (2.ter parameter):
	 * They map each row in the ResultSet to a specific Bean. 
	 * 
	 * And in our specific situation,
	 * our column names in the table match
	 * the exact names in the Bean.
	 * So if you look at the course id, name, and author
	 * and if you look at our table id, name, and author
	 * and therefore we can use something called
	 * BeanPropertyRowMapper.(Parameters:
	 * mappedClass : the class that each row should be mapped to.
	 * bei uns: Course)
	 */
	public Course findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY_PARAMETERIZED, new BeanPropertyRowMapper<Course>(Course.class), id);
	}
}
