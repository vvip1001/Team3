package com.job.coverletter.model.skill.dto;

public class SkillDto {

    // 시퀀스 
    private int skillseq;

    // 이메일(ID) 
    private String joinemail;

    // 구분 IT,자격증,어학,공모전
    private String category;

    // it기술 IT
    private String itskill;

    // 점수 IT, 1~10
    private int itscore;

    // 자격증명(n급) 자격증
    private String certificate;

    // 공인어학시험명 어학
    private String languagename;

    // 어학시험점수 어학
    private int languagescore;

    // 공모전명 공모전
    private String contest;

    // 수상 공모전
    private String prize;

    // 발행기관 시행기관, 발행기관
    private String organization;

    // 모든 취득일자 it는 제외, yyyy/mm/dd
    private String regdate;

    
    
    public SkillDto() {
		super();
	}

	public SkillDto(int skillseq, String joinemail, String category, String itskill, int itscore, String certificate,
			String languagename, int languagescore, String contest, String prize, String organization, String regdate) {
		super();
		this.skillseq = skillseq;
		this.joinemail = joinemail;
		this.category = category;
		this.itskill = itskill;
		this.itscore = itscore;
		this.certificate = certificate;
		this.languagename = languagename;
		this.languagescore = languagescore;
		this.contest = contest;
		this.prize = prize;
		this.organization = organization;
		this.regdate = regdate;
	}

	public int getSkillseq() {
        return skillseq;
    }

    public void setSkillseq(int skillseq) {
        this.skillseq = skillseq;
    }

    public String getJoinemail() {
        return joinemail;
    }

    public void setJoinemail(String joinemail) {
        this.joinemail = joinemail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItskill() {
        return itskill;
    }

    public void setItskill(String itskill) {
        this.itskill = itskill;
    }

    public int getItscore() {
        return itscore;
    }

    public void setItscore(int itscore) {
        this.itscore = itscore;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename;
    }

    public int getLanguagescore() {
        return languagescore;
    }

    public void setLanguagescore(int languagescore) {
        this.languagescore = languagescore;
    }

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

	@Override
	public String toString() {
		return "SkillDto [skillseq=" + skillseq + ", joinemail=" + joinemail + ", category=" + category + ", itskill="
				+ itskill + ", itscore=" + itscore + ", certificate=" + certificate + ", languagename=" + languagename
				+ ", languagescore=" + languagescore + ", contest=" + contest + ", prize=" + prize + ", organization="
				+ organization + ", regdate=" + regdate + "]";
	}
    
}
