package cn.itcast.service;

import java.util.List;

import cn.itcast.bean.Person;

public interface PersonService {
	/**
	 * ����person
	 * @param person
	 */
	public void save(Person person);
	/**
	 * ����person
	 * @param person
	 */
	public void update(Person person);
	/**
	 * ��ȡperson
	 * @param personid
	 * @return
	 */
	public Person getPerson(Integer personid);
	/**
	 * ��ȡ����person
	 * @return
	 */
	public List<Person> getPersons();
	/**
	 * ɾ��ָ��id��person
	 * @param personid
	 */
	public void delete(Integer personid);
}
