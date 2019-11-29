package com.yedam.exam.board.service;

import java.util.List;
import java.util.Map;

import com.yedam.exam.board.BoardSearchVO;
import com.yedam.exam.board.BoardVO;
import com.yedam.exam.board.common.Paging;

public interface BoardService {
	
	
	//전체조회-맵
	List<Map<String, Object>> getBoardListMap();

	//전체조회
	List<BoardVO> getBoardList(BoardSearchVO svo, Paging p);

	//단건조회
	BoardVO getBoard(BoardVO vo);

	//삭제
	int deleteBoard(BoardVO vo);

	//등록
	int insertBoard(BoardVO vo);

	//수정
	int updateBoard(BoardVO vo);


}