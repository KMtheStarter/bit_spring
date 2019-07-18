package di_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di_xml.xml");
		
		Car car = (Car) context.getBean("car"); // xml�� �ڵ����� setter ȣ��. �̰� �Ӽ�����.
		System.out.println("������ Ÿ�̾�: " + car.getTireBrand());
		System.out.println("����� Ÿ�̾�: " + car.getSpareTireBrand());
		
		Car car2 = (Car) context.getBean("car2");
		System.out.println("������ Ÿ�̾�: " + car2.getTireBrand());
		System.out.println("����� Ÿ�̾�: " + car2.getSpareTireBrand());
	}
}
