package com.yedam.exam.board;

import lombok.Data;

@Data
public class BoardSearchVO extends BoardVO {
	
	private String keyword;
	private String searchCondition;
	private int start; //페이징 시작-끝  범위용
	private int end;
}
