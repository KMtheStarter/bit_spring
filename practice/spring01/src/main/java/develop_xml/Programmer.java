package develop_xml;

import org.springframework.stereotype.Service;

@Service
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
