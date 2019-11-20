package co.sr.board.users;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.sr.board.vo.UserVO;

//@Service("userService")
@Component("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) { //setter를 통한 의존성주입
		this.userDao = userDao;
	}

	@Override
	public List<UserVO> select() {
		return userDao.select();
	}

	@Override
	public UserVO select(String id) {
		return userDao.select(id);
	}

	@Override
	public int insert(UserVO vo) {
		return userDao.insert(vo);
	}

	@Override
	public int delete(UserVO vo) {
		return userDao.delete(vo);
	}

	@Override
	public int update(UserVO vo) {
		return userDao.update(vo);
	}

}
