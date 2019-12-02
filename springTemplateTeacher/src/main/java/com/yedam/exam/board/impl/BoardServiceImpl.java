package com.yedam.exam.board.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.exam.board.BoardSearchVO;
import com.yedam.exam.board.BoardVO;
import com.yedam.exam.board.common.Paging;
import com.yedam.exam.board.dao.BoardDAO;
import com.yedam.exam.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	//@Autowired @Qualifier("dsfdsfdsfd") 리포지가 이름있을때
	@Autowired BoardDAO dao;
	
		
	@Override
	public List<BoardVO> getBoardList(BoardSearchVO svo, Paging paging) {
		//출력건수
		paging.setPageUnit(10);
		// 페이지번호 파라미터
		if( paging.getPage() == null) {
			paging.setPage(1); 
		}		
		// 시작/마지막 레코드 번호
		svo.setStart(paging.getFirst());
		svo.setEnd(paging.getLast());		
		// 전체 건수
		paging.setTotalRecord(dao.getBoardCount(svo));
		
		
		return dao.getBoardList(svo, paging);
	}

	@Override //map
	public List<Map<String, Object>> getBoardListMap() {
		return dao.getBoardListMap();
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return dao.deleteBoard(vo);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

}
