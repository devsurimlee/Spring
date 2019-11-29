package com.yedam.exam.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.exam.board.BoardSearchVO;
import com.yedam.exam.board.BoardVO;
import com.yedam.exam.board.common.Paging;
import com.yedam.exam.board.service.BoardService;

//아작스 처리용 컨트롤러
@RestController //@Controller + @RespnesBody
public class RestBoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/ajax/getBoardList.json")
	public List<BoardVO> getBoardList(BoardSearchVO svo, Paging p) {
		return boardService.getBoardList(svo, p);
	}
}
