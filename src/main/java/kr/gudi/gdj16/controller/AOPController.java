package kr.gudi.gdj16.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.gudi.gdj16.service.AOPServiceInterface;

@Controller
public class AOPController {
	
	/***********************************************************************************
	 * CRUD 구성하기 (URL : 9개)
	 * 화면	: JSP화면 출력 처리			목록		입력		자세히보기			수정
	 * 데이터	: JSON 자료형으로 출력 처리	목록리스트	입력결과	하나의 행가져오기	수정결과	삭제결과
	 * 
	 * JSP 	> String, ModelAndView
	 * JSON > void(직접 화면 출력), Model(ModelAndView)
	 * 
	 * Return > 있다(나머지) & 없다(void)
	 * 
	 * 관점 중요성 (종류별 관점 지향으로 개발이 필요하다)
	 * Controller(p1) 	Service(p2) Repository(p3)
	 * (뷰처리용 AOP)		    (데이터처리용 AOP)
	 ***********************************************************************************/

	@RequestMapping("/aop1")
	public String aop1() {
		System.out.println("리턴값이 String");
		return "aop";
	}
	
	@Autowired
	AOPServiceInterface aopsi;
	
	@RequestMapping("/aop2")
	public void aop2(HttpServletResponse res, HttpServletRequest req) throws Throwable {
		
		HashMap<String, Object> resultMap = aopsi.test(req);
		
		if(resultMap == null) {
			System.out.println("Service 리턴값 NULL 처리 완료");
		}
		
		System.out.println("리턴값이 void");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		res.getWriter().print("알려쥼");
	}
}
