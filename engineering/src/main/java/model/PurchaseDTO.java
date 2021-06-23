package model;

import java.util.Date;

public class PurchaseDTO {
	String purchNo;
	Date purchDate;
	String purchTotal;
	String purchAddr;
	String purchReceiver;
	String purchPhoneNumber;
	String purchMsg;
	String membId;
	public String getPurchNo() {
		return purchNo;
	}
	public void setPurchNo(String purchNo) {
		this.purchNo = purchNo;
	}
	public Date getPurchDate() {
		return purchDate;
	}
	public void setPurchDate(Date purchDate) {
		this.purchDate = purchDate;
	}
	public String getPurchTotal() {
		return purchTotal;
	}
	public void setPurchTotal(String purchTotal) {
		this.purchTotal = purchTotal;
	}
	public String getPurchAddr() {
		return purchAddr;
	}
	public void setPurchAddr(String purchAddr) {
		this.purchAddr = purchAddr;
	}
	public String getPurchReceiver() {
		return purchReceiver;
	}
	public void setPurchReceiver(String purchReceiver) {
		this.purchReceiver = purchReceiver;
	}
	public String getPurchPhoneNumber() {
		return purchPhoneNumber;
	}
	public void setPurchPhoneNumber(String purchPhoneNumber) {
		this.purchPhoneNumber = purchPhoneNumber;
	}
	public String getPurchMsg() {
		return purchMsg;
	}
	public void setPurchMsg(String purchMsg) {
		this.purchMsg = purchMsg;
	}
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
}
