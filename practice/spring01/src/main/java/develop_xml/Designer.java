package develop_xml;

import org.springframework.stereotype.Service;

@Service
public class Designer implements Developer{

	@Override
	public void gotoOffice() {
		System.out.println("디자이너 출근합니다.");
	}

	@Override
	public void getoutOffice() {
		System.out.println("디자이너 퇴근합니다.");
	}

	
}
