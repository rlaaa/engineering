package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import command.MemberCommand;
import model.AuthInfo;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberUpdateService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public int memUpdate(MemberCommand memberCommand, HttpSession session) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAddr(memberCommand.getDetailAddr());
		dto.setMembAddr(memberCommand.getMembAddr());
		dto.setMembConfirm(memberCommand.getMembConfirm());
		dto.setMembEmail(memberCommand.getMembEmail());
		dto.setMembPhoneNumber(memberCommand.getMembPhoneNumber());
		dto.setPostNumber(memberCommand.getPostNumber());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
							// (형변환) 오브젝트타입 이라서
		dto.setMembId(authInfo.getUserId());
		if(bcryptPasswordEncoder.matches(memberCommand.getMembPw(), authInfo.getUserPw())) {
										// 암호화 되지 않은 값,			암호화된 값				
			memberRepository.memUpdate(dto);
			session.removeAttribute("pwFail1");
			return 1;
		} else {
			session.setAttribute("pwFail1", "비밀번호가 일치하지 않습니다.");
			return 2;
		}
	}

}
