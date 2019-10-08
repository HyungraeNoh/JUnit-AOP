package kr.gudi.gdj16;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.gudi.gdj16.controller.HomeController;
import kr.gudi.gdj16.service.DBServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/test-context.xml"})
public class Step2Test {
	
	@Autowired
	HomeController hc;
	
	@Autowired
	DBServiceInterface dbsi;

	@Test
	public void test1() {
		System.out.println("test1()");
		hc.test();
	}
	
	@Test
	public void test2() {
		System.out.println("test2()");
		dbsi.test();
	}

}
