package com.yedam.exam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.exam.board.BoardVO;
import com.yedam.exam.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*-context.xml")
public class boardServiceTest {
	
	@Autowired
	BoardService boardService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Test
	public void test() {
		BoardVO vo = new BoardVO();
		vo.setSeq(102);
		BoardVO result = boardService.getBoard(vo);
		assertEquals(result.getTitle(), "222");			// 시퀀스가 102이고 타이틀 명이 '222'인 열 찾음
		
	}
	
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("juit-test");
		vo.setContent("junit-test");
		vo.setWriter("writer");
		boardService.insertBoard(vo);
	}

}
