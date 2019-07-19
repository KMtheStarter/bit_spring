package adult;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonMain {

	public static void main(String[] args) {

		int age = 1;
		boolean flag = true;
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Person c = context.getBean("customer", Person.class);

		Scanner s = new Scanner(System.in);
		while (flag) {
			age = Integer.parseInt(s.nextLine());
			if (age == -1) {
				flag = false;
			} else
				c.setAge(age);
		}
	}
}