package develop_java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DevelopMain {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		Develop dev = ac.getBean("develop", Develop.class);
		
		dev.doWorking();
	}
}
