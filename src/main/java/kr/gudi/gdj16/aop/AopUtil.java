package kr.gudi.gdj16.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AopUtil {
	
	public ModelAndView checkParams(ProceedingJoinPoint jp) throws Throwable {
		ModelAndView mav = new ModelAndView();
		Object[] obj = jp.getArgs();
		System.out.println("Param Size : " + obj.length);
		for(int i = 0; i < obj.length; i++) {
			Object object = obj[i]; 
			if(object instanceof HttpServletRequest) {
				if(checkRequest(object)) {
					mav.setViewName("aop");
					return mav; 
				}
			} else {
				System.out.println("다른 객체가 넘어왔다.");
			}
		}
		return (ModelAndView) jp.proceed();
	}
	
	public boolean checkRequest(Object obj) {
		System.out.println("HttpServletRequest 있음");
		HttpServletRequest req = (HttpServletRequest) obj;
		Enumeration<?> enu = req.getParameterNames();
		boolean flag = false;
		while(enu.hasMoreElements()) {
			String name = enu.nextElement().toString();
			String value = req.getParameter(name);
			System.out.println(name);
			System.out.println(value);
			if(("").equals(value)) {
				flag = true;
				break;						
			}
		}
		return flag;
	}

}
