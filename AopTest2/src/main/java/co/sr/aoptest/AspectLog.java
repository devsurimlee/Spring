package co.sr.aoptest;

import java.util.Date;

public class AspectLog { //Aspect 공통기능 
	private Date date;
	
	public void logOut() { //Advice JoinPoint에 동작하는 메소드
		date = new Date();
		System.out.println("로그아웃 시간:" + date);
	}
	
	public void logIn() {
		date = new Date();
		System.out.println("로그인 시간:" + date);
		
	}
	
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
}
