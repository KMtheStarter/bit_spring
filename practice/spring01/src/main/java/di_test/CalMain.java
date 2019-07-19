package di_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalMain {

    public static void main(String[] args){
    	
    	ApplicationContext ac = new GenericXmlApplicationContext("di_test_xml3.xml");
    	
    	MyCalculator myCalculator = (MyCalculator)ac.getBean("myCalculator");
    	
    	myCalculator.add();
    	myCalculator.sub();
    	myCalculator.mul();
    	myCalculator.div();
    }

}
