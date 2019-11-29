package com.yedam.exam;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.exam.jobboard.JobNotice;
import com.yedam.exam.jobboard.service.JobNoticeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*-context.xml")
public class JobNoticeServiceClient {
	
	@Resource JobNoticeService service;
	
	@Test
	public void test() {
		List<JobNotice> list = service.insertJobNotice();
		for(JobNotice jn : list) {
			System.out.println(jn);
		}
    }
}
