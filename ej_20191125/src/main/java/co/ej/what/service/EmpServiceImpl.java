package co.ej.what.service;

import java.util.List;


import co.ej.what.dao.EmpDAO;
import co.ej.what.vo.EmpVO;

//@Service("empService") xml로 주입
public class EmpServiceImpl implements EmpService{
	
	private EmpDAO empDao;
	
	@Override
	public List<EmpVO> select() {
		return empDao.select();
	}

	@Override
	public EmpVO select(int employeeId) {
		return empDao.select(employeeId);
	}

	@Override
	public int insert(EmpVO vo) {
		return 0;
	}

	@Override
	public int update(EmpVO vo) {
		return 0;
	}

	@Override
	public int delete(int employeeId) {
		return empDao.delete(employeeId);
	}

	public void setEmpDao(EmpDAO empDao) {
		this.empDao = empDao;
	}

}
