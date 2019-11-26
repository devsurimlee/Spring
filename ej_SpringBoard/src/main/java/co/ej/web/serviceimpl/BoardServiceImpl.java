package co.ej.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ej.web.dao.BoardDAO;
import co.ej.web.service.BoardService;
import co.ej.web.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
//	public void setBoardDao(BoardDAO boardDao) {
//		this.boardDao = boardDao;
//	}
	
	@Override
	public List<BoardVO> select() throws Exception {
		return boardDao.select();
	}

	@Override
	public BoardVO select(BoardVO vo) throws Exception {
		return boardDao.select(vo);
	}

	@Override
	public int insert(BoardVO vo) throws Exception {
		return boardDao.insert(vo);
	}

	@Override
	public int update(BoardVO vo) throws Exception {
		return boardDao.update(vo);
	}

	@Override
	public int delete(int seq) throws Exception {
		return boardDao.delete(seq);
	}

}
