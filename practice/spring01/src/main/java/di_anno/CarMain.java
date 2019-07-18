package di_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di_anno.xml");
		
		Car car = context.getBean("car", Car.class); // generic처럼 써보기. 명시적 캐스팅과 같다.
 		
		System.out.println("장착된 타이어: " + car.getTireBrand());
	}
}
