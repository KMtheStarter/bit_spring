package develop_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DevelopMain {

	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("develop.xml");
		Develop dev = ac.getBean("develop", Develop.class);
		
		dev.doWorking();
	}
}
