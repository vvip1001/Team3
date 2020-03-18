package com.job.coverletter.model.board.dto;

import java.util.Date;

public class BoardDto {
	// 시퀀스 
    private int boardseq;

    // 그룹번호 
    private int groupno;

    // 그룹의 글순서 
    private int groupseq;

    // 탭 
    private int titletab;

    // 이메일(ID) 
    private String joinemail;

    // 제목 
    private String title;

    // 내용 
    private String content;

    // 피일명(경로) 
    private String filepath;

    // 작성일 
    private Date regdate;
    
    
    
    public BoardDto() {
		super();
	}

	public BoardDto(int boardseq, int groupno, int groupseq, int titletab, String joinemail, String title,
			String content, String filepath, Date regdate) {
		super();
		this.boardseq = boardseq;
		this.groupno = groupno;
		this.groupseq = groupseq;
		this.titletab = titletab;
		this.joinemail = joinemail;
		this.title = title;
		this.content = content;
		this.filepath = filepath;
		this.regdate = regdate;
	}

	public int getBoardseq() {
        return boardseq;
    }

    public void setBoardseq(int boardseq) {
        this.boardseq = boardseq;
    }

    public int getGroupno() {
        return groupno;
    }

    public void setGroupno(int groupno) {
        this.groupno = groupno;
    }

    public int getGroupseq() {
        return groupseq;
    }

    public void setGroupseq(int groupseq) {
        this.groupseq = groupseq;
    }

    public int getTitletab() {
        return titletab;
    }

    public void setTitletab(int titletab) {
        this.titletab = titletab;
    }

    public String getJoinemail() {
        return joinemail;
    }

    public void setJoinemail(String joinemail) {
        this.joinemail = joinemail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

	@Override
	public String toString() {
		return "BoardDto [boardseq=" + boardseq + ", groupno=" + groupno + ", groupseq=" + groupseq + ", titletab="
				+ titletab + ", joinemail=" + joinemail + ", title=" + title + ", content=" + content + ", filepath="
				+ filepath + ", regdate=" + regdate + "]";
	}

    

}
