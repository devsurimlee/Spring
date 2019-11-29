package com.yedam.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UrlTest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        try {
        	//데이터 요청
        	URL url = new URL("http://localhost/exam/resources/jobBoard.json");
        	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        	BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
        	// String으로 변환
        	StringBuffer sb = new StringBuffer();
        	String str;
        	while( (str = br.readLine() ) != null  ) {
        		sb.append(str);
        	}
	     
        	//string -> object로 변환
        	ObjectMapper objectMapper = new ObjectMapper();   
        	List<Map<String, Object>> readValue = objectMapper.readValue(sb.toString(),
        										new TypeReference<List<Map<String, Object>>>() { });
        	//데이터변환하여 등록 처리
        	for (Map<String, Object> map : readValue) {
        		System.out.println( map.get("notcCont"));
        		//등록처리
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
