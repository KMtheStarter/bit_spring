package aop.adult;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {

	@After("execution(* *.setAge(..))")
    public void checkAdult(JoinPoint joinPoint) {
		Object[] objArr = joinPoint.getArgs();
    	if ((int)objArr[0] < 20) System.out.println("미성년입니다.");
    	else System.out.println("성년입니다.");
    }
	
	@Around("execution(* setAge(..))")
	public void checkAdult2(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object target = joinPoint.getTarget();
		
		System.out.println(target.getClass());
		System.out.println(joinPoint.getSignature());
		
		joinPoint.proceed();
		
		int age = 0;
		if(target instanceof Customer) {
			Customer custom = (Customer)target;
			age = custom.getAge();
		}
		
		if(age >= 20) {
			System.out.println("성년입니다.");
		} else {
			System.out.println("미성년입니다.");
		}
	}

}
