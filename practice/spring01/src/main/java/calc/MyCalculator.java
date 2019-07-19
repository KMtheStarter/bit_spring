package calc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 여기서 calculator 사용 및 실행
public class MyCalculator {
	
	public static void main(String[] args) {
								
		ApplicationContext ac = new GenericXmlApplicationContext("calc_xml.xml");
		ApplicationContext ac2 = new GenericXmlApplicationContext("calc_anno.xml");
		
		int firstNum = 15;
		int secondNum = 4;
		
		Calculator calc = ac.getBean("calculator", Calculator.class);
		System.out.println(calc.add(firstNum, secondNum));
		
		calc = (Calculator)ac.getBean("calculator2");
		System.out.println(calc.sub(firstNum, secondNum));
		
		calc = ac2.getBean("calculator", Calculator.class);
		System.out.println(calc.multi(firstNum, secondNum));

		calc = (Calculator)ac2.getBean("calc");
		System.out.println(calc.devide(firstNum, secondNum));
		
	}
}
