package com.job.coverletter.model.qnaboard.dto;

public class QnaBoardDto {

    // 시퀀스 
    private int oanboardseq;

    // 문제 
    private String question;

    // 답 
    private String answer;
    
    public QnaBoardDto() {
		super();
	}

	public QnaBoardDto(int oanboardseq, String question, String answer) {
		super();
		this.oanboardseq = oanboardseq;
		this.question = question;
		this.answer = answer;
	}

	public int getOanboardseq() {
        return oanboardseq;
    }

    public void setOanboardseq(int oanboardseq) {
        this.oanboardseq = oanboardseq;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

	@Override
	public String toString() {
		return "QnaBoardDto [oanboardseq=" + oanboardseq + ", question=" + question + ", answer=" + answer + "]";
	}

}