package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanContainer.xml");
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:beanContainer.xml");
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beanContainer.xml"); // 위 중 가운데 빼고 다 됨
		// Hello obj = new Hello(); 를 container가 관리하게 함.
		Hello obj = (Hello) ctx.getBean("hello"); // object로 return되는 객체를 명시적 형변환 해주어야 함.
		System.out.println("obj: " + obj);
		Hello obj2 = (Hello) ctx.getBean("hello");
		System.out.println("obj2: " + obj2); // 싱글턴 패턴이기 때문에 같은 주소가 찍힘.
		Hello obj3 = (Hello) ctx.getBean("hello2");
		System.out.println("obj3: " + obj3); // 다른 객체이기 때문에 당연히 다른 주소.
		
		

	}
}
