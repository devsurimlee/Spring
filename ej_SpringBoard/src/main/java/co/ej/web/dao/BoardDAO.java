package co.ej.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import co.ej.web.vo.BoardVO;

@Repository("boardDao")
public class BoardDAO extends JdbcDaoSupport {

	private final String BOARD_LIST = "select * from board";
	private final String BOARD_SELECT = "select * from board where seq=?";
	private final String BOARD_INSERT = "insert into board values(board_seq.nextval, ?, ?, ?, ?, 0)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, regdate=?, where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";

	@Autowired
	public void setSuperDataSource(DataSource dataSource) { // dataSource 연결
		super.setDataSource(dataSource);
	}

	public List<BoardVO> select() throws Exception {

		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}

	public BoardVO select(BoardVO vo) throws Exception {
		return getJdbcTemplate().queryForObject(BOARD_SELECT, new BoardRowMapper(), vo.getSeq());
	}

	public int insert(BoardVO vo) throws Exception {
		return getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getRegDate());

	}

	public int update(BoardVO vo) throws Exception {
		return getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getRegDate(), vo.getSeq());

	}

	public int delete(int seq) throws Exception {
		return getJdbcTemplate().update(BOARD_DELETE, seq);

	}
}
