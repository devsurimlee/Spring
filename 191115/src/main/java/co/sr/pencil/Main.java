package co.sr.pencil;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationCTX.xml");
		
		Pencil pencil = (Pencil) context.getBean("pencil"); //의존성 주입
		//Pencil pencil = new Pencil6BWithEraser(); //클래스 결합
		pencil.use();
		
		context.close();
	}
}
