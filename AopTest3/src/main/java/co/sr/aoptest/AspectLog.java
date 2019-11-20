package co.sr.aoptest;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//1. Aspect(공통부분)선언; 2. Pointcut 잡아줌;  3.advice 연결 

@Service
@Aspect
public class AspectLog { //Aspect 공통기능 
	
	@Pointcut("execution(* co.sr.aoptest.*Impl.*(..))") //JoinPoint 설정부분
	public void allPointCut(){}
	
	/*
	 *	private Date date;
	 *
	 * @Before("allPointCut()") public void logIn() { date = new Date();
	 * System.out.println("로그인 시간:" + date); }
	 * 
	 * @After("allPointCut()") public void logOut() { //Advice JoinPoint에 동작하는 메소드
	 * date = new Date(); System.out.println("로그아웃 시간:" + date); }
	 * 
	 * public void AutoComm() { System.out.println("오토커밋"); }
	 */
}
