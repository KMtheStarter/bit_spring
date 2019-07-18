package calc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

@Resource
public class Calculator {
	@Autowired
	public Calculator() {}
	//인자두개받아서 +-*/
	public int add(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int multi(int a, int b) {
		return a*b;
	}
	public double devide(int a, int b) {
		if (b != 0) return (double) a/b;
		return 0;
	}
}
