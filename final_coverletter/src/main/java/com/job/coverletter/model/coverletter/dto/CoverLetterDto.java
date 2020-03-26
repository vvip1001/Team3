package com.job.coverletter.model.coverletter.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CoverLetterDto {

	// 시퀀스
	private int coverletterseq;

	// 이메일(ID)
	private String joinemail;

	// 구분
	private String cvcategory;

	// 각각 구분 시퀀스
	private int groupseq;

	// 항목(질문)
	private String question;

	// 제목
	private String title;

	// 소제목
	private String subtitle;

	// 내용
	private String content;

	// 작성일
	private Date regdate;

	// 파일경로
	private String filepath;

	private MultipartFile uploadFile;

	private int StartIndex;
	private int CntPerPage;
	// 현재페이지
	private int curPage;

	/*---------- 검색 ----------*/
	private String category;
	private String keyword;

	public CoverLetterDto() {
	}

	public CoverLetterDto(int coverletterseq, String joinemail, String cvcategory, int groupseq, String question,
			String title, String subtitle, String content, Date regdate, String filepath) {
		this.coverletterseq = coverletterseq;
		this.joinemail = joinemail;
		this.cvcategory = cvcategory;
		this.groupseq = groupseq;
		this.question = question;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.regdate = regdate;
		this.filepath = filepath;
	}
	
	public CoverLetterDto(int coverletterseq, String joinemail, String cvcategory, int groupseq, String question,
			String title, String subtitle, String content, Date regdate, String filepath, MultipartFile uploadFile,
			int startIndex, int cntPerPage, int curPage, String category, String keyword) {
		super();
		this.coverletterseq = coverletterseq;
		this.joinemail = joinemail;
		this.cvcategory = cvcategory;
		this.groupseq = groupseq;
		this.question = question;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.regdate = regdate;
		this.filepath = filepath;
		this.uploadFile = uploadFile;
		StartIndex = startIndex;
		CntPerPage = cntPerPage;
		this.curPage = curPage;
		this.category = category;
		this.keyword = keyword;
	}

	public int getCoverletterseq() {
		return coverletterseq;
	}

	public void setCoverletterseq(int coverletterseq) {
		this.coverletterseq = coverletterseq;
	}

	public String getJoinemail() {
		return joinemail;
	}

	public void setJoinemail(String joinemail) {
		this.joinemail = joinemail;
	}

	public String getCvcategory() {
		return cvcategory;
	}

	public void setCvcategory(String cvcategory) {
		this.cvcategory = cvcategory;
	}

	public int getgroupseq() {
		return groupseq;
	}

	public void setgroupseq(int groupseq) {
		this.groupseq = groupseq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public int getStartIndex() {
		return StartIndex;
	}

	public void setStartIndex(int startIndex) {
		StartIndex = startIndex;
	}

	public int getCntPerPage() {
		return CntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		CntPerPage = cntPerPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Coverletter [coverletterseq=" + coverletterseq + ", joinemail=" + joinemail + ", cvcategory="
				+ cvcategory + ", groupseq=" + groupseq + ", question=" + question + ", title=" + title + ", subtitle="
				+ subtitle + ", content=" + content + ", regdate=" + regdate + ", filepath=" + filepath + "]";
	}

}