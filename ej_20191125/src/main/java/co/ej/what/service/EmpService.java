package co.ej.what.service;

import java.util.List;

import co.ej.what.vo.EmpVO;

public interface EmpService {

	public List<EmpVO> select();
	public EmpVO select(int employeeId);
	public int insert(EmpVO vo);
	public int update(EmpVO vo);
	public int delete(int employeeId);
}
