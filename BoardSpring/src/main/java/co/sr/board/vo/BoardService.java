package co.sr.board.vo;

public interface BoardService { //가급적 DAO메소드를 모두 포함해서 만든다
	
	public BoardVO select(); //return값 필요함
	public void insert(BoardVO dto);	
	public void delete(BoardVO dto);	
	public void update(BoardVO dto);	

}
