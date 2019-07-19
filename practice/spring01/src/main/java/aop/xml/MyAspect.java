package aop.xml;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	// joinpoint는 매개변수. 여긴 없다.
	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("출근합니다.");
		// joinPoint.getArgs();
	}
	
	public void getoffOffice() {
		System.out.println("퇴근합니다.");
	}
}
