package co.sr.aoptest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContect.xml");
		Board board = (Board) ctx.getBean("boardService");
		board.select();
		ctx.close();
	}

}
