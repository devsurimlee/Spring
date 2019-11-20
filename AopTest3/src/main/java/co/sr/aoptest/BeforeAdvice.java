package co.sr.aoptest;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice { 
	
	private Date date;
	
	////pointcut과 advice분리 클래스명.메소드()
	 @Before("AspectLog.allPointCut()") 
	 public void logIn() { 
		 date = new Date();
		 System.out.println("로그인 시간:" + date); 
	}
}
