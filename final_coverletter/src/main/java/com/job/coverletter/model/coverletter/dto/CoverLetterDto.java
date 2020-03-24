package com.job.coverletter.model.coverletter.dto;

import java.util.Date;

public class CoverLetterDto {

    // 시퀀스 
    private int coverletterseq;

    // 이메일(ID) 
    private String joinemail;

    // 구분 
    private String cvcategory;

    // 각각 구분 시퀀스 
    private int gropuseq;

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
    

    public CoverLetterDto() {
		super();
	}

	public CoverLetterDto(int coverletterseq, String joinemail, String cvcategory, int gropuseq, String question,
			String title, String subtitle, String content, Date regdate, String filepath) {
		super();
		this.coverletterseq = coverletterseq;
		this.joinemail = joinemail;
		this.cvcategory = cvcategory;
		this.gropuseq = gropuseq;
		this.question = question;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.regdate = regdate;
		this.filepath = filepath;
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

    public int getGropuseq() {
        return gropuseq;
    }

    public void setGropuseq(int gropuseq) {
        this.gropuseq = gropuseq;
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

	@Override
	public String toString() {
		return "Coverletter [coverletterseq=" + coverletterseq + ", joinemail=" + joinemail + ", cvcategory="
				+ cvcategory + ", gropuseq=" + gropuseq + ", question=" + question + ", title=" + title + ", subtitle="
				+ subtitle + ", content=" + content + ", regdate=" + regdate + ", filepath=" + filepath + "]";
	}
    
    

}
