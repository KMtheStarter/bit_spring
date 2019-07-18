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
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beanContainer.xml"); // �� �� ��� ���� �� ��
		// Hello obj = new Hello(); �� container�� �����ϰ� ��.
		Hello obj = (Hello) ctx.getBean("hello"); // object�� return�Ǵ� ��ü�� ����� ����ȯ ���־�� ��.
		System.out.println("obj: " + obj);
		Hello obj2 = (Hello) ctx.getBean("hello");
		System.out.println("obj2: " + obj2); // �̱��� �����̱� ������ ���� �ּҰ� ����.
		Hello obj3 = (Hello) ctx.getBean("hello2");
		System.out.println("obj3: " + obj3); // �ٸ� ��ü�̱� ������ �翬�� �ٸ� �ּ�.
		
		

	}
}
