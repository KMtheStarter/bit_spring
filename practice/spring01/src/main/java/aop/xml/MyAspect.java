package aop.xml;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	// joinpoint�� �Ű�����. ���� ����.
	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("����մϴ�.");
		// joinPoint.getArgs();
	}
	
	public void getoffOffice() {
		System.out.println("����մϴ�.");
	}
}
