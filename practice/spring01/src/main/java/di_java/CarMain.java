package di_java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//		Tire tire = context.getBean("kumTire", Tire.class);
//		System.out.println(tire.getBrand());
		Car car = context.getBean("car", Car.class); // genericó�� �Ẹ��. ����� ĳ���ð� ����.
 		
		System.out.println("������ Ÿ�̾�: " + car.getTireBrand());
	}
}
