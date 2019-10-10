package kr.gudi.gdj16.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class AOPService implements AOPServiceInterface {

	@Override
	public HashMap<String, Object> test(HttpServletRequest req) {
		System.out.println("Service Test!!");
		return new HashMap<String, Object>();
	}

}
