package co.sr.aoptest;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardImpl implements Board {
	
	private BoardVO vo;

	@Override
	public void select() {
		vo = new BoardVO();
		vo.setId(1);
		vo.setTitle("I love you, Emma");
		vo.setContents("~~~");
		vo.setWriter("Norman");
		vo.setHit(0);
		
		System.out.println(vo);

	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
