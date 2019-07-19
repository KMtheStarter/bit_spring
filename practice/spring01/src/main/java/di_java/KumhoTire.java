package di_java;

import org.springframework.stereotype.Component;

@Component
public class KumhoTire implements Tire{

	public String getBrand() {
		return "금호타이어";
	}
	
	public KumhoTire() {
		System.out.println("KumhoTire() 생성");
	}
}
