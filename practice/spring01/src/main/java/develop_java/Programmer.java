package develop_java;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Developer {

	@Override
	public void gotoOffice() {
		System.out.println("���α׷��� ����մϴ�.");
	}

	@Override
	public void getoutOffice() {
		System.out.println("���α׷��� ����մϴ�.");
		
	}
	
}
