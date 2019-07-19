package adult;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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

}
