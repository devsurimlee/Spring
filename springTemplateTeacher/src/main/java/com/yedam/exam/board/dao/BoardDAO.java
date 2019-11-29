package com.yedam.exam.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.exam.board.BoardSearchVO;
import com.yedam.exam.board.BoardVO;
import com.yedam.exam.board.common.Paging;

@Repository
public class BoardDAO  {
	
	@Autowired 
	SqlSessionTemplate mybatis;
	
	//전체조회
	public List<BoardVO> getBoardList(BoardSearchVO svo, Paging p) { //키워드값 넘겨줌
		return mybatis.selectList("BoardDAO.getBoardList", svo);
	}
	
	//건수조회
	public int getBoardCount(BoardSearchVO svo) {
		return mybatis.selectOne("BoardDAO.getBoardCount", svo);
	}
	
	//전체조회-맵
	public List<Map<String, Object>> getBoardListMap() {
		return mybatis.selectList("BoardDAO.getBoardListMap");
	}
	
	//단건조회
	public BoardVO getBoard(BoardVO vo) {
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	//삭제
	public int deleteBoard(BoardVO vo) {
		return mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	//등록
	public int insertBoard(BoardVO vo) {
		return mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	//수정
	public int updateBoard(BoardVO vo) {
		return mybatis.insert("BoardDAO.updateBoard", vo);
	}
	
}
