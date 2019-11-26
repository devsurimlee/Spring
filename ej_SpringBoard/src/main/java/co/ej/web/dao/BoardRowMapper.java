package co.ej.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.ej.web.vo.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setContent(rs.getString("content"));
		vo.setRegDate(rs.getDate("regdate"));
		vo.setWriter(rs.getString("writer"));
		vo.setCnt(rs.getInt("cnt"));
		
		return vo;
	}

}
