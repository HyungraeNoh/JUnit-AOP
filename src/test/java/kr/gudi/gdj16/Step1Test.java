package kr.gudi.gdj16;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Step1Test {
	
	int a = 5;
	int b = 3;
	String name = "";
	
	Step1 s1 = new Step1();
	
	@Before
	public void step_1() {
//		System.out.println("Before");
	}
	@After
	public void step_2() {
		System.out.println("After : " + name);
		System.out.println(s1.t);
	}

	@Test
	public void test1() {
		name = "test1";
		System.out.println("test1()");
		assertEquals(true, s1.sum(a,b));
	}

	@Test
	public void test2() {
		name = "test2";
		System.out.println("test2()");
		assertEquals((a+b), s1.t);
	}
}
