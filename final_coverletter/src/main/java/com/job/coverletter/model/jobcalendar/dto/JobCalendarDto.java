package com.job.coverletter.model.jobcalendar.dto;

public class JobCalendarDto {
	   // 시퀀스 
    private int jobcalendarseq;

    // 이메일(ID) 
    private String joinemail;

    // 회사번호 
    private int companyseq;

    // 회사명 
    private String companyname;

    // 모집대상(채용제목) 
    private String business;

    // 마감일 날짜 OR 상시모집
    private String enddate;
    
    
    public JobCalendarDto() {
		super();
	}

	public JobCalendarDto(int jobcalendarseq, String joinemail, int companyseq, String companyname, String business,
			String enddate) {
		super();
		this.jobcalendarseq = jobcalendarseq;
		this.joinemail = joinemail;
		this.companyseq = companyseq;
		this.companyname = companyname;
		this.business = business;
		this.enddate = enddate;
	}

	public int getJobcalendarseq() {
        return jobcalendarseq;
    }

    public void setJobcalendarseq(int jobcalendarseq) {
        this.jobcalendarseq = jobcalendarseq;
    }

    public String getJoinemail() {
        return joinemail;
    }

    public void setJoinemail(String joinemail) {
        this.joinemail = joinemail;
    }

    public int getCompanyseq() {
        return companyseq;
    }

    public void setCompanyseq(int companyseq) {
        this.companyseq = companyseq;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

	@Override
	public String toString() {
		return "JabCalendarDto [jobcalendarseq=" + jobcalendarseq + ", joinemail=" + joinemail + ", companyseq="
				+ companyseq + ", companyname=" + companyname + ", business=" + business + ", enddate=" + enddate + "]";
	}
    
    
}
