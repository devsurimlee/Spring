package com.yedam.exam.jobboard.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.exam.jobboard.JobNotice;

@Repository
public class JobNoticeDAO {

	@Autowired private SqlSessionTemplate mybatis;
	
	public int insertJobNotice(JobNotice jn)  {
		return mybatis.insert("JobDAO.insertJobNotice", jn);
	}
}
