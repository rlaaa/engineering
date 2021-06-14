package command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberCommand {
	String membId;
	String membPw;
	String membPwCon;
	String membName;
	String postNumber;
	String membAddr;
	String detailAddr;
	String membPhoneNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date membBirth;
	String membGender;
	String membEmail;
	String membConfirm;
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
	public String getMembPw() {
		return membPw;
	}
	public void setMembPw(String membPw) {
		this.membPw = membPw;
	}
	public String getMembPwCon() {
		return membPwCon;
	}
	public void setMembPwCon(String membPwCon) {
		this.membPwCon = membPwCon;
	}
	public String getMembName() {
		return membName;
	}
	public void setMembName(String membName) {
		this.membName = membName;
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	public String getMembAddr() {
		return membAddr;
	}
	public void setMembAddr(String membAddr) {
		this.membAddr = membAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getMembPhoneNumber() {
		return membPhoneNumber;
	}
	public void setMembPhoneNumber(String membPhoneNumber) {
		this.membPhoneNumber = membPhoneNumber;
	}
	public Date getMembBirth() {
		return membBirth;
	}
	public void setMembBirth(Date membBirth) {
		this.membBirth = membBirth;
	}
	public String getMembGender() {
		return membGender;
	}
	public void setMembGender(String membGender) {
		this.membGender = membGender;
	}
	public String getMembEmail() {
		return membEmail;
	}
	public void setMembEmail(String membEmail) {
		this.membEmail = membEmail;
	}
	public String getMembConfirm() {
		return membConfirm;
	}
	public void setMembConfirm(String membConfirm) {
		this.membConfirm = membConfirm;
	}
	public boolean isMembPwEqualsMembPwCon() {
		if(membPwCon.equals(membPw)) {
			return true;
		}else {
			return false;
		}
	}
}
