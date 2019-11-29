package com.yedam.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

	public static void main(String[] args) {
	    final String uri = "http://localhost/exam/resources/jobBoard.json";
	    RestTemplate restTemplate = new RestTemplate();
	     
	    Map<String,Object>[] mapArr = restTemplate.getForObject(uri, Map[].class);
	    List<Map<String,Object>> list = Arrays.asList(mapArr);

	    System.out.println(list.get(0).get("emplNotcId"));
	}

}
