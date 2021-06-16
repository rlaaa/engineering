package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.main.LoginService;

@Controller
public class MainController {
	@Autowired
	LoginService loginService;
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public String aaaa() {
		return"main";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="loginId") String loginId, 
						@RequestParam(value="loginPw") String loginPw,
						HttpServletRequest request) {
		loginService.login(loginId, loginPw, request);
		return "redirect:main";
	}
	@RequestMapping("/logout")
	public String bbb(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
}
