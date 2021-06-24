package model;

import java.util.Date;

public class ReviewDTO {
	String purchNo;
	String prodNo;
	String cateNum;
	Date reviewDate;
	String reviewContent;
	String reviewReply;
	String empNo;
	public String getPurchNo() {
		return purchNo;
	}
	public void setPurchNo(String purchNo) {
		this.purchNo = purchNo;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getCateNum() {
		return cateNum;
	}
	public void setCateNum(String cateNum) {
		this.cateNum = cateNum;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewReply() {
		return reviewReply;
	}
	public void setReviewReply(String reviewReply) {
		this.reviewReply = reviewReply;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
}
