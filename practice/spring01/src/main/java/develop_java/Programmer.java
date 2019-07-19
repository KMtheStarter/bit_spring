package develop_java;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Developer {

	@Override
	public void gotoOffice() {
		System.out.println("프로그래머 출근합니다.");
	}

	@Override
	public void getoutOffice() {
		System.out.println("프로그래머 퇴근합니다.");
		
	}
	
}
