package com.yedam.exam.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//게시판 목록출력
	@RequestMapping("/ajax/getBoardList.json") 
	public List<BoardVO> getBoardList(BoardSearchVO svo, Paging p) {
		return boardService.getBoardList(svo, p);
	}
	
	//게시판글 등록 
	// JSP에서 json으로 보내서 파싱 필요함 + @RequestBody 추가함
	// value = ajax url; consumes = ajax contentType
	@RequestMapping(value= "/ajax/insertBoard.json", consumes="application/json")
	public BoardVO insertBoard(@RequestBody BoardVO vo) {
		boardService.insertBoard(vo);
		return vo;
	}
	
	//게시판 글 삭제 
	// value="baord/{seq}/{name} 값 여러개 넘길수있음 @PathVariable 변수1, @Pathvariable 변수2
	@RequestMapping(value ="board/{seq}", method= RequestMethod.DELETE)
	public int deleteBoard(@PathVariable int seq, BoardVO vo) {
		vo.setSeq(seq);
		boardService.deleteBoard(vo);
		return seq;
	}
	
	//단건 조회
	@RequestMapping(value ="board/{seq}", method = RequestMethod.GET)
	public BoardVO getBoard(@PathVariable int seq, BoardVO vo) {
		vo.setSeq(seq);
		return boardService.getBoard(vo);
	}
}
