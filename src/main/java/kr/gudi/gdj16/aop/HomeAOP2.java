package kr.gudi.gdj16.aop;

import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HomeAOP2 {
	
	@Pointcut("within(kr.gudi.gdj16.controller.AOPController)")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before(JoinPoint jp) {
		System.out.println(jp.getSignature().toShortString() + " : Start!");
	}
	
	@After("pointcut()")
	public void after(JoinPoint jp) {
		System.out.println(jp.getSignature().toShortString() + " : End!");
	}
	@AfterReturning(pointcut = "pointcut()", returning = "retVal")
	public void afterReturning(JoinPoint jp, Object retVal) throws Throwable {
		System.out.println(retVal);
		if(retVal == null) { // 리턴값이 void일 경우
			Object[] obj = jp.getArgs();
			for(int i = 0; i < obj.length; i++) {
				Object object = obj[i]; 
				if(object instanceof HttpServletResponse) {
					HttpServletResponse res = (HttpServletResponse) object;
					res.reset();
					res.setCharacterEncoding("UTF-8");
					res.setContentType("text/html; charset=UTF-8");
					res.getWriter().print("안알려쥼");
				}
			}
		}
		System.out.println(jp.getSignature().toShortString() + " : AfterReturning!");
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP!!");
		return jp.proceed();
	}
	
}
