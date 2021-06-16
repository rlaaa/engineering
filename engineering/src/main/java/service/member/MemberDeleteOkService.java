package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.AuthInfo;
import repository.MemberRepository;

public class MemberDeleteOkService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void del(HttpSession session, String memPw) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membPw = authInfo.getUserPw();
		String membId = authInfo.getUserId();
		if(bcryptPasswordEncoder.matches(memPw, membPw) ) {
			memberRepository.memDel(membId);
		}
		
		
	}

}
