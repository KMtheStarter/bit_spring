package di_java;

import org.springframework.stereotype.Component;

@Component
public class KumhoTire implements Tire{

	public String getBrand() {
		return "��ȣŸ�̾�";
	}
	
	public KumhoTire() {
		System.out.println("KumhoTire() ����");
	}
}
