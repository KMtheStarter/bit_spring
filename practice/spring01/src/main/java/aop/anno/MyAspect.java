package aop.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	// joinpoint는 매개변수. 여긴 없다.
	@Before("execution(* *.work())")
	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("출근합니다.");
	}
	
	@After("execution(* aop.anno.*.work())")
	public void getoffOffice() {
		System.out.println("퇴근합니다.");
	}
}
