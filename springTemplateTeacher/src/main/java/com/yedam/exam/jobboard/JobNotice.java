package com.yedam.exam.jobboard;

import java.util.Date;

public class JobNotice {
	private String  noticeDate;  //채용 공고일
	private String noticeIden;  //채용공고 ID
	private String noticeState;  //채용공고명
	private Integer person;		 //채용인원
	private String qualiField;	 //자격분야
	private String languageCode; //언어코드
	private String contents;     //채용내용  
	private String manager;      //담당자명
	private Date applyDate;    //채용접수일
	private Date maganDate;    //마감일

	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeIden() {
		return noticeIden;
	}
	public void setNoticeIden(String noticeIden) {
		this.noticeIden = noticeIden;
	}
	public void setPerson(Integer person) {
		this.person = person;
	}
	public String getNoticeState() {
		return noticeState;
	}
	public void setNoticeState(String noticeState) {
		this.noticeState = noticeState;
	}
	public String getQualiField() {
		return qualiField;
	}
	public void setQualiField(String qualiField) {
		this.qualiField = qualiField;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Date getMaganDate() {
		return maganDate;
	}
	public void setMaganDate(Date maganDate) {
		this.maganDate = maganDate;
	}
	public Integer getPerson() {
		return person;
	}
	@Override
	public String toString() {
		return "JobNotice [noticeDate=" + noticeDate + ", noticeIden=" + noticeIden + ", noticeState=" + noticeState
				+ ", person=" + person + ", qualiField=" + qualiField + ", languageCode=" + languageCode + ", contents="
				+ contents + ", manager=" + manager + ", applyDate=" + applyDate + ", maganDate=" + maganDate + "]";
	}
}	