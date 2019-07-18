package di_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di_anno.xml");
		
		Car car = context.getBean("car", Car.class); // genericó�� �Ẹ��. ����� ĳ���ð� ����.
 		
		System.out.println("������ Ÿ�̾�: " + car.getTireBrand());
	}
}
