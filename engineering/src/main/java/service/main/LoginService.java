package service.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.AuthInfo;
import repository.LoginRepository;

public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void login(String loginId, String loginPw, HttpServletRequest request) {
		AuthInfo authInfo = loginRepository.login(loginId);
		HttpSession session = request.getSession();
		if(authInfo == null) {
			session.setAttribute("userFail", "아이디가 존재하지 않습니다.");
			session.removeAttribute("pwFail");
		}else {
			if(bcryptPasswordEncoder.matches(loginPw, authInfo.getUserPw())) {
				///// 로그인 정보를 가진 session
				session.setAttribute("authInfo", authInfo);
				/////
				session.removeAttribute("pwFail");
				session.removeAttribute("userFail");
			}else {
				session.removeAttribute("userFail");
				session.setAttribute("pwFail", "비밀번호가 틀렸습니다.");
			}
		}
	}

}
