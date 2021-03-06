package com.yedam.exam.board;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardVO {

	private int seq;
	private String title;
	private String writer;
	private int cnt;
	//@JsonIgnore 
	private String content;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
	private Date regDate;
	private String uploadFilename;
}
