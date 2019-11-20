package co.sr.board.users;


import java.util.List;

import co.sr.board.vo.UserVO;

public interface UserService {

	public List<UserVO> select();

	public UserVO select(String id);

	public int insert(UserVO vo);

	public int delete(UserVO vo);

	public int update(UserVO vo);

}