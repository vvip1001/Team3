package com.job.coverletter.model.supportPay.dto;

public class SupportPayDto {
	 // 시퀀스 
    private int supportpayseq;

    // 이메일(ID) 
    private String joinemail;

    // 금액 
    private String money;

    // 예금주 
    private String depositor;

    // 은행 
    private String bank;

    // 계좌번호 
    private String banknumber;

    // 거래완료코드 
    private String successcord;

    // 거래날짜 
    private String tradedate;
    
    
    public SupportPayDto() {
		super();
	}

	public SupportPayDto(int supportpayseq, String joinemail, String money, String depositor, String bank,
			String banknumber, String successcord, String tradedate) {
		super();
		this.supportpayseq = supportpayseq;
		this.joinemail = joinemail;
		this.money = money;
		this.depositor = depositor;
		this.bank = bank;
		this.banknumber = banknumber;
		this.successcord = successcord;
		this.tradedate = tradedate;
	}

	public int getSupportpayseq() {
        return supportpayseq;
    }

    public void setSupportpayseq(int supportpayseq) {
        this.supportpayseq = supportpayseq;
    }

    public String getJoinemail() {
        return joinemail;
    }

    public void setJoinemail(String joinemail) {
        this.joinemail = joinemail;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getSuccesscord() {
        return successcord;
    }

    public void setSuccesscord(String successcord) {
        this.successcord = successcord;
    }

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }

	@Override
	public String toString() {
		return "SupportPayDto [supportpayseq=" + supportpayseq + ", joinemail=" + joinemail + ", money=" + money
				+ ", depositor=" + depositor + ", bank=" + bank + ", banknumber=" + banknumber + ", successcord="
				+ successcord + ", tradedate=" + tradedate + "]";
	}
    
    
}
