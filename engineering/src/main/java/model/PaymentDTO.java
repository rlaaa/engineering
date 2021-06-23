package model;

public class PaymentDTO {
	String payNo;
	String purchNo;
	String payMethod;
	String payAccNum;
	String payPrice;
	String payDate;
	String payCardBank;
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getPurchNo() {
		return purchNo;
	}
	public void setPurchNo(String purchNo) {
		this.purchNo = purchNo;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getPayAccNum() {
		return payAccNum;
	}
	public void setPayAccNum(String payAccNum) {
		this.payAccNum = payAccNum;
	}
	public String getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayCardBank() {
		return payCardBank;
	}
	public void setPayCardBank(String payCardBank) {
		this.payCardBank = payCardBank;
	}
	
}
