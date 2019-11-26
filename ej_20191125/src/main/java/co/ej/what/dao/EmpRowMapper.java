package co.ej.what.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.ej.what.vo.EmpVO;

public class EmpRowMapper implements RowMapper<EmpVO> {

	@Override
	public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmpVO vo = new EmpVO();

		vo.setEmployeeId(rs.getInt("employee_id"));
		vo.setFirstName(rs.getString("first_name"));
		vo.setDepartmentId(rs.getInt("department_id"));
		vo.setJobId(rs.getString("job_id"));
		vo.setSalary(rs.getInt("salary"));

		return vo;
	}

}
