package di_test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyCalculator {
	/* @Autowired */
	@Value("10")
    private int firstNum;
	/* @Autowired */ @Value("7")
    private int secondNum;
    @Autowired
    private Calculator calculator;

//    @Autowired
//    @Value("13")
    public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
    
//    @Autowired
	public void setSecondNum(/* @Value("5") */int secondNum) {
		this.secondNum = secondNum;
	}

//	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
    public void add(){
    	calculator.addition(firstNum, secondNum);
    }

	public void sub(){
    	calculator.subtraction(firstNum, secondNum);
    }

    public void mul(){
    	calculator.multiplication(firstNum, secondNum);
    }

    public void div(){
    	calculator.division(firstNum, secondNum);
    }

    public MyCalculator(){
    	System.out.println("MyCalcultor() »£√‚");
    }

    
	public MyCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	/* @Autowired */
	public MyCalculator(/* @Value("14") */int firstNum, /* @Value("5") */int secondNum, Calculator calculator) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.calculator = calculator;
	}
    
}
