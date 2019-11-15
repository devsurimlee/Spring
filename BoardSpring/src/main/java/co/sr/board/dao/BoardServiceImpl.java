package co.sr.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sr.board.vo.BoardService;
import co.sr.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public BoardVO select() {
		return boardDAO.select();
	}

	@Override
	public void insert(BoardVO dto) {
		boardDAO.insert(dto);
	}

	@Override
	public void delete(BoardVO dto) {
		boardDAO.delete(dto);
	}

	@Override
	public void update(BoardVO dto) {
		boardDAO.update(dto);
	}

}
