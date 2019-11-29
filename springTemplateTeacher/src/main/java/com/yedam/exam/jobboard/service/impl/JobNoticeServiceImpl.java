package com.yedam.exam.jobboard.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yedam.exam.jobboard.JobNotice;
import com.yedam.exam.jobboard.dao.JobNoticeDAO;
import com.yedam.exam.jobboard.service.JobNoticeService;

@Service
public class JobNoticeServiceImpl implements JobNoticeService {
	@Resource JobNoticeDAO dao;
	
	@Override
	public List<JobNotice> insertJobNotice() {
		final String uri = "http://localhost/exam/resources/jobBoard.json";
	    RestTemplate restTemplate = new RestTemplate();
	     
	    Map<String,Object>[] mapArr = restTemplate.getForObject(uri, Map[].class);
	    List<Map<String,Object>> list = Arrays.asList(mapArr);
	    
	    // 매핑
	    List<JobNotice> vo = new ArrayList<JobNotice>();
	    for (Map<String, Object> map : list) {
	    	JobNotice job = new JobNotice();
	    	job.setNoticeIden(((String)map.get("emplNotcId")).substring(4)); // 년도 제외한 월일 네자리
	    	job.setNoticeState((String)map.get("emplNotcCont"));
	    	job.setPerson(Integer.parseInt((String)map.get("emplExptPers"))); // obj to int
	    	
	    	// 자격코드 -> 자격분야
	    	String licnCode = (String)map.get("licnCode");
	    	switch(licnCode) {
	    	case "1001" :
	    	case "1002" :
	    		licnCode = "1";
	    		break;
	    	case "1004" :
	    		licnCode = "2";
	    		break;
	    	case "3003" :
	    		licnCode = "301";
	    		break;
	    	}
	    	job.setQualiField(licnCode);
	    	
	    	job.setLanguageCode((String)map.get("langCode"));
	    	job.setContents((String)map.get("notcCont"));
	    	job.setManager((String)map.get("mngeId"));
	    	job.setNoticeDate((String)map.get("notcRegtDt"));
	    	// string to date
	    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	    	Date applyDate = null;
	    	Date magamDate = null;
			try {
				applyDate = format.parse((String)map.get("recvStrtDt"));
				magamDate = format.parse((String)map.get("recvEndDt"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	job.setApplyDate(applyDate);
	    	job.setMaganDate(magamDate);
	    	
	    	vo.add(job);
	    }
	    
	    // insert
	    for(JobNotice j : vo) {
	    	dao.insertJobNotice(j);
	    }
	    
	    return vo;
	}

}
