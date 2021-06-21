package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import model.AuthInfo;
import service.member.MemberDeleteOkService;
import service.member.MemberDeleteService;
import service.member.MemberDetailService;
import service.member.MemberInfoService;
import service.member.MemberListService;
import service.member.MemberModifyService;
import service.member.MemberPwChangeService;
import service.member.MemberUpdateService;
import service.member.MemberjoinService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberjoinService memberjoinService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteOkService memberDeleteOkService;
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping("memReget")
	public String memReget() {
		return "member/memberForm";
	}
	@RequestMapping(value = "memJoin", method = RequestMethod.POST)
	public String memJoin(MemberCommand memberCommand) {
		memberjoinService.memberInsert(memberCommand);
		System.out.println(memberCommand.getMembAddr());
		return "redirect:../main";
	}
	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.memList(model);
		return "member/memberList";
	}
	@RequestMapping("memInfo")
	public String memInfo(@RequestParam(value="memId") String memId,
				Model model) {
		memberInfoService.memInfo(memId, model);
		return "member/memberInfo";
	}
	@RequestMapping("memModify")
	public String memModify(@RequestParam(value="memId") String memId,
			Model model) {
		memberInfoService.memInfo(memId, model);
		return "member/memberModify";
	}
	@RequestMapping("memModifyOk")
	public String memModifyOk(MemberCommand memberCommand) {
		memberModifyService.memUpdate(memberCommand);
		return "redirect:memInfo?memId=" + memberCommand.getMembId();
		
	}
	@RequestMapping("memDel")
	public String memDel(@RequestParam(value="memId") String memId) {
		memberDeleteService.memDel(memId);
		return "redirect:memList";
	}
	@RequestMapping("memMyPage")
	public String myPage() {
		return "member/memMyPage";
	}
	@RequestMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		memberDetailService.memInfo(session, model);
		return "member/memDetail";
	}
	@RequestMapping("memUpdate")
	public String memUpdate(HttpSession session, Model model) {
		memberDetailService.memInfo(session, model);
		return "member/memUpdate";
	}
	@RequestMapping("memUpdateOk")
	public String updateOk(MemberCommand memberCommand, HttpSession session) {
		int i = memberUpdateService.memUpdate(memberCommand, session);
		if(i == 1) {
			return "redirect:myInfo";
		}else {
			return "redirect:memUpdate";
		}		
	}
	@RequestMapping("memDelete")
	public String memDelete() {
		return "member/memDelete";
	}
	@RequestMapping("memDeleteOk")
	public String memDeleteOk(@RequestParam(value="membPw") String membPw, HttpSession session) {
		memberDeleteOkService.del(session, membPw);
								// 서비스로 넘길때 이 순서가 중요 (위에 괄호 안 순서는 상관 없음)
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("pwChange")
	public String pwChange() {
		return "member/pwChange";
	}
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@RequestMapping("pwChangeCnf")
	public String pwChangeCnf(HttpSession session, @RequestParam(value="membPw") String membPw) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userPw = authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(membPw, userPw)) {
			return "member/pwChangeCnf";
		}else {
			return "member/pwChange";
			// 페이지는 member/pwChangeCnf 주소로 열리지만 /pwChange 페이지를 띄워줌
		}
		
	}
	@Autowired
	MemberPwChangeService memberPwChangeService;
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(HttpSession session, @RequestParam(value="membPw") String membPw,
							@RequestParam(value="newPw") String newPw, @RequestParam(value="newPwCon") String newPwCon) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		String pw = authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(membPw, pw)) {
			if(newPw.contentEquals(newPwCon)) {
				// 비밀번호변경
				newPw = bcryptPasswordEncoder.encode(newPw);
				memberPwChangeService.pwOk(userId, newPw);
				return "redirect:/";
			}else {
				return "member/pwChangeCnf";
			}
		}else {
			return "member/pwChangeCnf";
		}	
		
		
			
		
	}
}
