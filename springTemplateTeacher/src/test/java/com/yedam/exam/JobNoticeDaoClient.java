package com.yedam.exam;

import java.util.Date;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.exam.jobboard.JobNotice;
import com.yedam.exam.jobboard.dao.JobNoticeDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*-context.xml")
public class JobNoticeDaoClient {
	
	@Resource JobNoticeDAO dao;
	
	@Test
	public void test() {
		JobNotice jobNotice = new JobNotice();
		jobNotice.setNoticeDate("20191101");
		jobNotice.setNoticeIden("00001");
		jobNotice.setNoticeState("state");
		jobNotice.setPerson(5);
		jobNotice.setQualiField("100");
		jobNotice.setLanguageCode("1001");
		jobNotice.setContents("content");
		jobNotice.setManager("tom");
		jobNotice.setApplyDate(new Date(2019,11,10));
		jobNotice.setMaganDate(new Date(2019,11,20));
		int r = dao.insertJobNotice(jobNotice);
		System.out.println(r+"=====");
    }
}
