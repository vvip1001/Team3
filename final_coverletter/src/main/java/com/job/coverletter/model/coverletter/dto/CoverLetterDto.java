package com.job.coverletter.model.coverletter.dto;

import java.util.Date;

public class CoverLetterDto {

    // 시퀀스 
    private int coverletterseq;

    // 이메일(ID) 
    private String joinemail;

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
    
    
    
    

    public CoverLetterDto() {
		super();
	}

	public CoverLetterDto(int coverletterseq, String joinemail, String question, String title, String subtitle,
			String content, Date regdate) {
		super();
		this.coverletterseq = coverletterseq;
		this.joinemail = joinemail;
		this.question = question;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.regdate = regdate;
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

    
	@Override
	public String toString() {
		return "Coverletter [coverletterseq=" + coverletterseq + ", joinemail=" + joinemail + ", question=" + question
				+ ", title=" + title + ", subtitle=" + subtitle + ", content=" + content + ", regdate=" + regdate + "]";
	}

    

}
