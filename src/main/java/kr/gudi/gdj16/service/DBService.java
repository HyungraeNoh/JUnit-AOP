package kr.gudi.gdj16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gudi.gdj16.dao.DBDaoInterface;

@Service
public class DBService implements DBServiceInterface {
	
//	@Autowired
//	DBDaoInterface dbdi;

	@Override
	public void test() {
		System.out.println("DBService.test()");
	}
	
}
