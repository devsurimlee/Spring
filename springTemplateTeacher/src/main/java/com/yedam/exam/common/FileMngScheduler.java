package com.yedam.exam.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yedam.exam.users.UserService;

@Component
public class FileMngScheduler {
	
	
	
	@Autowired UserService service;
	
	//@Scheduled(cron = "0/30 * 9 * * *") //매분 30초마다
	public void fileMng1() {
		System.out.println("스케쥴 실행1~~");
	}
	
	//@Scheduled(fixedDelay = 10000) //종료후 10초 대기
	public void fileMng2() {
		System.out.println("스케쥴 실행2~~delay");
		System.out.println(service.getUserList(null));
		
	}
	
	//@Scheduled(fixedRate = 10000) //10초간격
	public void fileMng3() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("스케쥴 실행3~~rate");
	}
}
