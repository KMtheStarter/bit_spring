package develop_xml;

import org.springframework.stereotype.Service;

@Service
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
