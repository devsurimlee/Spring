package co.sr.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import co.sr.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password ="hr";
	
	
	public BoardDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//
	
	public BoardVO select() { //DTO , 더미데이터 1행임
		BoardVO dto = new BoardVO();
			
		String sql ="select * from board";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getDate("regDate"));
				dto.setCnt(rs.getInt("cnt"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void insert(BoardVO dto) {
		
	}
	
	public void delete(BoardVO dto) {
		
	}
	
	public void update(BoardVO dto) {
		
	}
}
