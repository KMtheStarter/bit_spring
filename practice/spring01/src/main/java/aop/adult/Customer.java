package aop.adult;

import org.springframework.stereotype.Component;

@Component
public class Customer implements Person {

	private int age;
	
	public Customer() {
		
	}
	public Customer(int age) {
		this.age = age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	
}
