package di_test;

public class MyCalculator {
    private int firstNum;
    private int secondNum;
    private Calculator calculator;

    public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

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
    }

    
	public MyCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public MyCalculator(int firstNum, int secondNum, Calculator calculator) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.calculator = calculator;
	}
    
}
