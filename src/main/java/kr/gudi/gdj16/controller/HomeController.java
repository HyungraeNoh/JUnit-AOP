package kr.gudi.gdj16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.gudi.gdj16.service.DBServiceInterface;

@Controller
public class HomeController {

	@Autowired
	DBServiceInterface dbsi;
	
	public void test() {
		dbsi.test();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
//		System.out.println("HomeController.home() : Start");
		
		int cnt = 0;
		while(true) {
			if(cnt > 1000000000) break;
//			System.out.println("SIZE : " + cnt);
			cnt++;
		}
		
//		System.out.println("HomeController.home() : End");
		return "home";
	}
	
}
