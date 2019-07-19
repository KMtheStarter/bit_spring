package aop.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	// joinpoint�� �Ű�����. ���� ����.
	@Before("execution(* *.work())")
	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("����մϴ�.");
	}
	
	@After("execution(* aop.anno.*.work())")
	public void getoffOffice() {
		System.out.println("����մϴ�.");
	}
}
