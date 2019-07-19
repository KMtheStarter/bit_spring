package aop.java;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	// joinpoint�� �Ű�����. ���� ����.
	@Before("execution(* *.work())")
	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("����մϴ�.");
	}
	
	@After("execution(* aop.java.*.work())")
	public void getoffOffice() {
		System.out.println("����մϴ�.");
	}
}
