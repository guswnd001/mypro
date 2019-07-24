package model;

import java.util.Date;

public class Comment {

	private long commentNo;
	private String userId;
	private Date regDate;
	private String commentContent;
	
	
	
	//'default생성자'는 만들지 않아도 어느 자바클래스든 이미 가지고 있다.
	//파라미터가 있는 생성자를 만든다면 default생성자를 꼭 만들어 줘야 한다.
	
	public Comment() {
	}
	
	public Comment(long commentNo, String userId, Date regDate, String commentContent) {
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentContent = commentContent;
		this.regDate = regDate;
	}
	
	
	public long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	
	@Override
	public String toString() {
		return "\nComment [commentNo=" + commentNo + ", userId=" + userId + ", regDate=" + regDate + ", commentContent="
				+ commentContent + "]";
	}
	
}
