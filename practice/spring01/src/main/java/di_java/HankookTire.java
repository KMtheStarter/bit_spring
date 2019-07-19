package di_java;

import org.springframework.stereotype.Component;

@Component("hanTire")
public class HankookTire implements Tire{

	public String getBrand() {
		return "한국타이어";
	}

	public HankookTire() {
		System.out.println("HankookTire() 생성");
	}
	
}
