package co.sr.board.users;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import co.sr.board.users.common.UserRowMapper;
import co.sr.board.vo.UserVO;

@Repository
public class UserDAO extends JdbcDaoSupport {
	private String sql = "select * from users";
	
	/* extends DAO > JdbcDaoSupport 변경하면서 필요없어짐
	 * public UserDAO() { super(); }
	 */
	
	private final String ALL_USER_LIST = "select * from users";
	private final String ONE_USER_LIST = "select * from users where id = ?";
	private final String USER_INSERT = "insert into users values (?, ?, ?, ?)";
	private final String USER_UPDATE = "update users set password = ? where id = ?";
	private final String USER_DELETE = "delete from users where id = ? ";
	
	@Autowired
	public void SetDataSourceTag(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public List<UserVO> select() { //회원 전체 정보 가져오기
		return getJdbcTemplate().query(ALL_USER_LIST, new UserRowMapper()); //query: list 리턴
	}
	

	public UserVO select(String id) { //회원 1명 정보 가져오기
		return getJdbcTemplate().queryForObject(ONE_USER_LIST, new UserRowMapper(), id); //queryForObject: 하나의 도메인객체 or 컬럼하나 리턴
	}

	public int insert(UserVO vo) {
		return getJdbcTemplate().update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	public int delete(UserVO vo) {
		return getJdbcTemplate().update(USER_DELETE, vo.getId());
		
	}

	public int update(UserVO vo) {
		return 0;
		
	}
	
	/*
	 * public ArrayList<UserVO> select() { 
	 * ArrayList<UserVO> list = new ArrayList<UserVO>(); UserVO dto = new UserVO();
	 * 
	 * try {
		 *  pstmt = conn.prepareStatement(sql); 
		 *  rs = pstmt.executeQuery();
		 * 
			 * while(rs.next()) { 
			 * dto = new UserVO(); dto.setId(rs.getString("id"));
			 * dto.setPassword(rs.getString("password")); 
			 * dto.setName(rs.getString("name"));
			 * dto.setRole(rs.getString("role"));
		 * 
		 	* list.add(dto); 
		 	* } close();
		 * 
		 * } catch (SQLException e) { 
		 * 		e.printStackTrace(); 
		 * }
		 * 
		 * return list; 
	 * }//
	 * 
	 * public UserVO select (String id) { UserVO dto = new UserVO(); String sql =
	 * "select * from users where id = ? ";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery();
	 * 
	 * if(rs.next()) { dto.setId(rs.getString("id"));
	 * dto.setPassword(rs.getString("password")); dto.setName(rs.getString("name"));
	 * dto.setRole(rs.getString("role")); } close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return dto; }
	 * 
	 * 
	 * public void insert(UserVO vo) { //회원등록 String sql =
	 * "insert into users values(?, ?, ?, ?)";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); pstmt.setString(1, vo.getId());
	 * pstmt.setString(2, vo.getPassword()); pstmt.setString(3, vo.getName());
	 * pstmt.setString(4, vo.getRole());
	 * 
	 * int r = pstmt.executeUpdate(); System.out.println( r + "건 회원등록 되었습니다");
	 * 
	 * close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * public void delete(UserVO vo) { //회원삭제 String sql =
	 * "delete from users where id = ? ";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); pstmt.setString(1, vo.getId());
	 * 
	 * int r = pstmt.executeUpdate(); System.out.println( r + "건 회원삭제 되었습니다");
	 * 
	 * close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * public void update(UserVO vo) { //회원갱신 String sql =
	 * "update users set name = ? where id = ? ";
	 * 
	 * 
	 * try { pstmt = conn.prepareStatement(sql); pstmt.setString(1, vo.getName());
	 * pstmt.setString(2, vo.getId());
	 * 
	 * int r = pstmt.executeUpdate(); System.out.println( r + "건 회원갱신 되었습니다");
	 * 
	 * close(); } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 */
}
