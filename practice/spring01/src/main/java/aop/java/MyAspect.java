package aop.java;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	// joinpoint는 매개변수. 여긴 없다.
	@Before("execution(* *.work())")
	public void gotoOffice(JoinPoint joinPoint) {
		System.out.println("출근합니다.");
	}
	
	@After("execution(* aop.java.*.work())")
	public void getoffOffice() {
		System.out.println("퇴근합니다.");
	}
}
