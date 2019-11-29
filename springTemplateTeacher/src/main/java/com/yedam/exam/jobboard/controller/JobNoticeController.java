package com.yedam.exam.jobboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.exam.jobboard.service.JobNoticeService;

@Controller
public class JobNoticeController {
	
	@Autowired
	JobNoticeService jobNoticeService;
	
	@RequestMapping("jobNoticeInsert.do")
	public String jobNoticeInsert(Model model) {
		model.addAttribute("jobNoticeList", jobNoticeService.insertJobNotice());
		return "jobNoticeList";
	}
}
