package aop.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*Spring AOP 특징
1. Proxy 기반
2. 런타임 기반
3. 인터페이스 기반
*/
public class EmpMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Employee e = context.getBean("designer", Employee.class); // aop할땐 무조건 인터페이스 기반!!!!!!!!!!
		e.work();
	}
}
