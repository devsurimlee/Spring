package co.sr.board.users.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.sr.board.vo.UserVO;

public class UserRowMapper implements RowMapper<UserVO> {
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO vo = new UserVO();
		vo.setId(rs.getString("id"));
		vo.setPassword(rs.getString("password"));
		vo.setName(rs.getString("name"));
		vo.setRole(rs.getString("role"));
		
		return vo;
	}
}
