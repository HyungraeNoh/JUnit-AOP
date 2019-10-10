package kr.gudi.gdj16.aop;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
public class HomeAOP3 {
	
	@Pointcut("within(kr.gudi.gdj16.service.AOPService)")
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
		System.out.println(jp.getSignature().toShortString() + " : AfterReturning!");
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP!!");
		
		Object[] obj = jp.getArgs();
		System.out.println("Param Size : " + obj.length);
		for(int i = 0; i < obj.length; i++) {
			Object object = obj[i]; 
			if(object instanceof HttpServletRequest) {
				HttpServletRequest req = (HttpServletRequest) object;
				Enumeration<?> enu = req.getParameterNames();
				List<String> paramNames = new ArrayList<String>();
				while(enu.hasMoreElements()) {
					String name = enu.nextElement().toString();
					String value = req.getParameter(name);
					System.out.println(name);
					System.out.println(value);
					paramNames.add(name);
				}
				boolean flag = true;
				for(int j = 0; j < paramNames.size(); j++) {
					if("name".equals(paramNames.get(i))) {
						flag = false;
					}
				}
				if(flag) return null;  
			} 
		}
		
		return jp.proceed();
	}
	
}
