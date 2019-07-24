package kr.co.mlec.board.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class BoardVO {

	private int 	no, viewCnt;
	@Length(min=2, max=50, message="2글자 이상 50글자 이하로 입력하세요.")
	@NotEmpty(message="필수항목입니다.")
	private String  title;
	@NotEmpty(message="필수항목입니다.")
	@Pattern(regexp="^[A-Za-z0-9]*$", message="특수기호는 사용할 수 없습니다.")
	private String	writer;
	private String	content, regDate;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int no, int viewCnt, String title, String writer, String content, String regDate) {
		super();
		this.no = no;
		this.viewCnt = viewCnt;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", viewCnt=" + viewCnt + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
	
}
