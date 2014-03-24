import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bean.Person;
import cn.itcast.service.PersonService;


public class callTest {
	private static PersonService personService;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			personService = (PersonService) cxt.getBean("personService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}		
		for(int i=0; i<5; i++)
			personService.save(new Person("´«ÖÇ²¥¿Í"+ i));
	}

}
