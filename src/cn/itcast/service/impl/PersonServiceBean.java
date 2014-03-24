package cn.itcast.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Person;
import cn.itcast.service.PersonService;

@Transactional
public class PersonServiceBean implements PersonService {
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void delete(Integer personid) {
		jdbcTemplate.update("delete from person where id=?", new Object[]{personid},
				new int[]{java.sql.Types.INTEGER});
	}

	public Person getPerson(Integer personid) {		
		return (Person)jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{personid}, 
				new int[]{java.sql.Types.INTEGER}, new PersonRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return (List<Person>)jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public void save(Person person) {
		jdbcTemplate.update("insert into person(name) values(?)", new Object[]{person.getName()},
				new int[]{java.sql.Types.VARCHAR});
	}

	public void update(Person person) {
		jdbcTemplate.update("update person set name=? where id=?", new Object[]{person.getName(), person.getId()},
				new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
	}
}
