package cn.itcast.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.itcast.bean.Person;

public class PersonRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Person person = new Person(rs.getString("name"));
		person.setId(rs.getInt("id"));
		return person;
	}
}
