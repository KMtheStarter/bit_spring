package di_java;

import org.springframework.stereotype.Component;

@Component("hanTire")
public class HankookTire implements Tire{

	public String getBrand() {
		return "�ѱ�Ÿ�̾�";
	}

	public HankookTire() {
		System.out.println("HankookTire() ����");
	}
	
}
