package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * Spring AOP Ư¡
1. Proxy ���
2. ��Ÿ�� ���
3. �������̽� ���
*/
public class EmpMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop_xml.xml");
		
		Employee e = context.getBean("designer", Employee.class); // aop�Ҷ� ������ �������̽� ���!!!!!!!!!!
		e.work();
	}
}
