package com.job.coverletter.model.total.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class TotalDto {
	// ----------------------JoinUserDto--------------------------
	
	// 회원번호(SEQ) 
    private int joinseq;

	 // 이메일(ID) 
    @NotEmpty(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식이 틀렸습니다.")
    private String joinemail;

    // 이름 
    @NotEmpty(message = "이름을 입력해주세요")
    @Pattern(regexp = "[가-힣]*$", message = "이름은 한글만 사용해주세요")
    private String joinname;

    // 비밀번호 
    @Pattern(regexp="^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "숫자 영어 혼합으로 6~20자리로")
    private String joinpw;

    // 생년월일 
    @Pattern(regexp = "^[0-9]*$", message = "형식을 맞춰주세요")
    @Length(min = 6, max = 6, message = "형식을 맞춰주세요")
    private String joinbirth;

    // 성별 
    @NotEmpty(message = "성별을 선택해주세요")
    private String joinsex;

    // 사진 
    private String photo;

    // 병역 
    @Pattern(regexp = "^(미필)|(군필)|(면제)$", message = " 병역을 선택해주세요.")
    private String mililtary;

    // 전화번호 
    @NotEmpty(message = "전화번호를 입력해주세요.")
    private String phone;

    // 주소
    @NotEmpty(message = "주소를 입력해주세요.")
    private String address;

    // 카카오 
    private String kakao;

    // 회원가입 여부 
    private String singup;
    
	// ----------------------SkillDto--------------------------
    
    // 시퀀스 
    private int skillseq;

    // 구분 IT,자격증,어학,공모전
    private String category;

    // it기술 IT
    @NotEmpty(message = "기술을 입력해주세요")
    private String itskill;

    // 점수 IT, 1~10
    @Pattern(regexp = "[1-9]$|(10)$", message = "1~10점 까지 표시해주세요")
    private String itscore;

    // 자격증명(n급) 자격증
    private String certificate;

    // 공인시험명 어학점수
    private String languagename;

    // 공인시험점수 어학점수
    private int languagescore;

    // 공모전명 공모전
    private String contest;

    // 수상이력 공모전
    private String prize;

    // 발행기관 시행기관, 발행기관
    private String organization;

    // 모든 취득일자 it는 제외, yyyy/mm/dd
    @Pattern(regexp = "^(([0-9][0-9])[년]([0-1][0-9])[월]([0-1][0-9])[일]$)", message = "yy년mm월dd일 형태로 작성해주세요.")
    private String regdate;

	// ----------------------SchoolDto--------------------------

    // SCHOOLSEQ 
    private int schoolseq;

    // 학력구분(학위)
    @Pattern(regexp = "^(대졸)|(전문대졸)|(고졸)$", message = "학력구분을 선택해주세요")
    private String career;

    // 학교명 
    @NotEmpty(message = "학교명을 입력해주세요")
    private String schoolname;

    // 입학년월
    @Pattern(regexp = "^(([0-9][0-9])[년]([0-1][0-9])[월]([0-3][0-9])[일]$)", message = "yy년mm월dd일 형태로 작성해주세요.")
    private String admission;
    
    // 졸업년월 재학중, 중퇴...
    @Pattern(regexp = "^(([0-9][0-9])[년]([0-1][0-9])[월]([0-3][0-9])[일]$)", message = "yy년mm월dd일 형태로 작성해주세요.")
    private String graduate;

    // 전공명 
    @NotEmpty(message = "값을 입력해주세요")
    private String major;

    // 학점 4.0 / 3,5...
    @Pattern(regexp = "^[1-3][.]\\d{1}|[4][.][0-5]{1}$", message = "4.5 형태로 작성해주세요")
    private String grade;

 // ----------------------JoinUserDto--------------------------
    
    public int getJoinseq() {
		return joinseq;
	}

	public void setJoinseq(int joinseq) {
		this.joinseq = joinseq;
	}
    
	public String getJoinemail() {
		return joinemail;
	}

	public void setJoinemail(String joinemail) {
		this.joinemail = joinemail;
	}

	public String getJoinname() {
		return joinname;
	}

	public void setJoinname(String joinname) {
		this.joinname = joinname;
	}

	public String getJoinpw() {
		return joinpw;
	}

	public void setJoinpw(String joinpw) {
		this.joinpw = joinpw;
	}

	public String getJoinbirth() {
		return joinbirth;
	}

	public void setJoinbirth(String joinbirth) {
		this.joinbirth = joinbirth;
	}

	public String getJoinsex() {
		return joinsex;
	}

	public void setJoinsex(String joinsex) {
		this.joinsex = joinsex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMililtary() {
		return mililtary;
	}

	public void setMililtary(String mililtary) {
		this.mililtary = mililtary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKakao() {
		return kakao;
	}

	public void setKakao(String kakao) {
		this.kakao = kakao;
	}

	public String getSingup() {
		return singup;
	}

	public void setSingup(String singup) {
		this.singup = singup;
	}
	
	
	
	public TotalDto() {
		
	}

	public TotalDto(int joinseq, String joinemail, String joinname, String joinpw, String joinbirth, String joinsex, String photo, String mililtary, String phone,
			String address, String kakao, String singup) {
		this.joinseq = joinseq;
		this.joinemail = joinemail;
		this.joinname = joinname;
		this.joinpw = joinpw;
		this.joinbirth = joinbirth;
		this.joinsex = joinsex;
		this.photo = photo;
		this.mililtary = mililtary;
		this.phone = phone;
		this.address = address;
		this.kakao = kakao;
		this.singup = singup;
	}

	// ----------------------SkillDto--------------------------
	
	public int getSkillseq() {
		return skillseq;
	}

	public void setSkillseq(int skillseq) {
		this.skillseq = skillseq;
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

	public String getItscore() {
		return itscore;
	}

	public void setItscore(String itscore) {
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

	public TotalDto(String joinemail, int skillseq, String category, String itskill, String itscore, String certificate, String languagename, int languagescore, String contest,
			String prize, String organization,String regdate) {
		this.joinemail = joinemail;
		this.skillseq = skillseq;
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

	// ----------------------SchoolDto--------------------------
	
	public int getSchoolseq() {
		return schoolseq;
	}

	public void setSchoolseq(int schoolseq) {
		this.schoolseq = schoolseq;
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

	public TotalDto(String joinemail, int schoolseq, String career, String schoolname, String admission, String graduate, String major, String grade) {
		this.joinemail = joinemail;
		this.schoolseq = schoolseq;
		this.career = career;
		this.schoolname = schoolname;
		this.admission = admission;
		this.graduate = graduate;
		this.major = major;
		this.grade = grade;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
    
    
	
    
    
    


}
