package com.yedam.exam.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.exam.board.BoardSearchVO;
import com.yedam.exam.board.BoardVO;
import com.yedam.exam.board.common.Paging;
import com.yedam.exam.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;

	  //목록조회
	  @RequestMapping("getBoardList") 
	  public String getBoardList(Model model, BoardSearchVO svo, Paging p) { 
		  model.addAttribute("boardList", boardService.getBoardList(svo, p)); //커맨드객체는 모델에 저장
		  model.addAttribute("paging", p);
		  
		  return "board/getBoardList"; //forword
	  }
	  
		
	//목록조회 - 맵
	@RequestMapping("getBoardListMap")
	public String getBoardListMap(Model model, BoardSearchVO svo, BoardVO vo) {
		model.addAttribute("boardList", boardService.getBoardListMap());
		
		return "board/getBoardList"; 
	}
	  
	 
	//등록페이지 가기
	@RequestMapping("insertBoardForm")
	public String insertBoardForm() {
		return "board/insertBoard";
	}
	
	//글등록처리
	@RequestMapping("insertBoard")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:getBoardList";
	}

}
