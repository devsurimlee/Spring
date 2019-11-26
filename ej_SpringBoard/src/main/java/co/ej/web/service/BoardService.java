package co.ej.web.service;

import java.util.List;

import co.ej.web.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> select() throws Exception;
	public BoardVO select(BoardVO vo) throws Exception;
	public int insert(BoardVO vo) throws Exception;
	public int update(BoardVO vo) throws Exception;
	public int delete(int seq) throws Exception;
}
