package co.sr.aoptest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationConfig.xml");
		
		//2. 사용할 컨테이너 찾기
		Student student = (Student) ctx.getBean("student");
		
		//3. 컨테이너 실행
		student.toString();
		
		//4. 컨테이너 닫기
		ctx.close();
	}

}
