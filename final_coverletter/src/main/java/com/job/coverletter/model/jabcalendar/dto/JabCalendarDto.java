package com.job.coverletter.model.jabcalendar.dto;

public class JabCalendarDto {
	// 시퀀스 
    private int jabcalendarseq;

    // 이메일(ID) 
    private String joinemail;

    // 회사명 
    private String companyname;

    // 마감일 마감일이 있는 것만 여기 등록
    private String enddate;
    
    

    public JabCalendarDto() {
		super();
	}

	public JabCalendarDto(int jabcalendarseq, String joinemail, String companyname, String enddate) {
		super();
		this.jabcalendarseq = jabcalendarseq;
		this.joinemail = joinemail;
		this.companyname = companyname;
		this.enddate = enddate;
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

	@Override
	public String toString() {
		return "JabCalendar [jabcalendarseq=" + jabcalendarseq + ", joinemail=" + joinemail + ", companyname="
				+ companyname + ", enddate=" + enddate + "]";
	}
    
    
}
