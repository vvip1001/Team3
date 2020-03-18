package com.job.coverletter.model.school.dto;

public class SchoolDto {
	 // SCHOOLSEQ 
    private int schoolseq;

    // 이메일(ID) 
    private String joinemail;

    // 학력구분(학위) 
    private String career;

    // 학교명 
    private String schoolname;

    // 입학년월 
    private String admission;

    // 졸업년월 재학중, 중퇴...
    private String graduate;

    // 전공명 
    private String major;

    // 학점 4.0 / 3,5...
    private String grade;
    
    
    public SchoolDto() {
		super();
	}

	public SchoolDto(int schoolseq, String joinemail, String career, String schoolname, String admission,
			String graduate, String major, String grade) {
		super();
		this.schoolseq = schoolseq;
		this.joinemail = joinemail;
		this.career = career;
		this.schoolname = schoolname;
		this.admission = admission;
		this.graduate = graduate;
		this.major = major;
		this.grade = grade;
	}

	public int getSchoolseq() {
        return schoolseq;
    }

    public void setSchoolseq(int schoolseq) {
        this.schoolseq = schoolseq;
    }

    public String getJoinemail() {
        return joinemail;
    }

    public void setJoinemail(String joinemail) {
        this.joinemail = joinemail;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

	@Override
	public String toString() {
		return "SchoolDto [schoolseq=" + schoolseq + ", joinemail=" + joinemail + ", career=" + career + ", schoolname="
				+ schoolname + ", admission=" + admission + ", graduate=" + graduate + ", major=" + major + ", grade="
				+ grade + "]";
	}
    
    
}
