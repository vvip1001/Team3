package com.job.coverletter.model.jobcalendar.dto;

public class JobCalendarDto {
	// 시퀀스 
    private int jabcalendarseq;

    // 이메일(ID) 
    private String joinemail;

    // 회사명 
    private String companyname;

    // 마감일 마감일이 있는 것만 여기 등록
    private String enddate;
    
    private int StartIndex;
	private int CntPerPage;
	// 현재페이지
	private int curPage;

	/*---------- 검색 ----------*/
	private String category;
	private String keyword;

    public JobCalendarDto() {
		super();
	}

	public JobCalendarDto(int jabcalendarseq, String joinemail, String companyname, String enddate) {
		super();
		this.jabcalendarseq = jabcalendarseq;
		this.joinemail = joinemail;
		this.companyname = companyname;
		this.enddate = enddate;
	}
	
	public JobCalendarDto(int jabcalendarseq, String joinemail, String companyname, String enddate, int startIndex,
			int cntPerPage, int curPage, String category, String keyword) {
		super();
		this.jabcalendarseq = jabcalendarseq;
		this.joinemail = joinemail;
		this.companyname = companyname;
		this.enddate = enddate;
		StartIndex = startIndex;
		CntPerPage = cntPerPage;
		this.curPage = curPage;
		this.category = category;
		this.keyword = keyword;
	}

	public int getJabcalendarseq() {
        return jabcalendarseq;
    }

    public void setJabcalendarseq(int jabcalendarseq) {
        this.jabcalendarseq = jabcalendarseq;
    }

    public String getJoinemail() {
        return joinemail;
    }

    public void setJoinemail(String joinemail) {
        this.joinemail = joinemail;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
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
		return "JabCalendar [jabcalendarseq=" + jabcalendarseq + ", joinemail=" + joinemail + ", companyname="
				+ companyname + ", enddate=" + enddate + "]";
	}
    
    
}
