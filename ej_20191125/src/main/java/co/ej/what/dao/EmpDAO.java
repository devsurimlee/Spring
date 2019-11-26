package co.ej.what.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import co.ej.what.vo.EmpVO;

public class EmpDAO extends JdbcDaoSupport {
	
	
	private final String EMP_SELECT = "select * from emp";
	private final String EMP_SELECT_ONE = "select * from emp where employee_id=?";
	private final String EMP_DELETE = "delete from emp where employee_id=?";

	public List<EmpVO> select() {
		List<EmpVO> a = null;

		try {
			a = getJdbcTemplate().query(EMP_SELECT, new EmpRowMapper());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	public EmpVO select(int employeeId) {
		EmpVO a = null;

		try {
			a = getJdbcTemplate().queryForObject(EMP_SELECT_ONE, new EmpRowMapper(), employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	public int delete(int employeeId) {
		int a = 0;

		try {
			a = getJdbcTemplate().update(EMP_DELETE, employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}
}
