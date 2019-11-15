package co.sr.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import co.sr.board.vo.BoardService;
import co.sr.board.vo.BoardVO;

public class Main {
	
	public static void main(String[] args) {
		AbstractApplicationContext cnt = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) cnt.getBean("boardService"); //@Service
		
		BoardVO vo = new BoardVO(); //DTO 선언
		vo = boardService.select();
		System.out.println(vo.toString());
		
		cnt.close();
	} 
}
