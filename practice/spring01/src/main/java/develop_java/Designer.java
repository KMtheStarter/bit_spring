package develop_java;

import org.springframework.stereotype.Component;

@Component
public class Designer implements Developer{

	@Override
	public void gotoOffice() {
		System.out.println("�����̳� ����մϴ�.");
	}

	@Override
	public void getoutOffice() {
		System.out.println("�����̳� ����մϴ�.");
	}

	
}
