package aop.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*Spring AOP Ư¡
1. Proxy ���
2. ��Ÿ�� ���
3. �������̽� ���
*/
public class EmpMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Employee e = context.getBean("designer", Employee.class); // aop�Ҷ� ������ �������̽� ���!!!!!!!!!!
		e.work();
	}
}
