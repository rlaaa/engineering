package controller.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import model.AuthInfo;
import service.employees.EmployeeDeleteOkService;
import service.employees.EmployeeDeleteService;
import service.employees.EmployeeDetailService;
import service.employees.EmployeeInfoService;
import service.employees.EmployeeListService;
import service.employees.EmployeeModifyService;
import service.employees.EmployeeNoService;
import service.employees.EmployeePwChangeService;
import service.employees.EmployeeService;
import service.employees.EmployeeUpdateService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeNoService employeeNoService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteOkService employeeDeleteOkService;
	@Autowired
	EmployeePwChangeService employeePwChangeService;
	
	@RequestMapping("empMyPage")
	public String empMyPage() {
		return "employee/empMyPage";
	}
	@RequestMapping("empMyInfo")
	public String empMyInfo(HttpSession session, Model model) {
		employeeDetailService.empInfo(session, model);
		return "employee/empDetail";
	}
	@RequestMapping("empUpdate")
	public String empUpdate(HttpSession session, Model model) {
		employeeDetailService.empInfo(session, model);
		return "employee/empUpdate";
	}
	@RequestMapping("empUpdateOk")
	public String empUpdateOk(EmployeeCommand employeeCommand, HttpSession session) {
		int i = employeeUpdateService.empUpdate(employeeCommand, session);
		if(i == 1) {
			return "redirect:empMyInfo";
		}else {
			return "redirect:empUpdate";
		}		
	}
	@RequestMapping("empInfoDel")
	public String empInfoDel() {
		return "employee/empInfoDel";
	}
	@RequestMapping("empDeleteOk")
	public String empDeleteOk(@RequestParam(value="empPw") String empPw, HttpSession session) {
		employeeDeleteOkService.del(session, empPw);
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("pwChange")
	public String pwChange() {
		return "employee/pwChange";
	}
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@RequestMapping("pwChangeCnf")
	public String pwChangeCnf(HttpSession session, @RequestParam(value="empPw") String empPw) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userPw = authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(empPw, userPw)) {
			return "employee/pwChangeCnf";
		}else {
			return "employee/pwChange";
		}
	}
	
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(HttpSession session, @RequestParam(value="empPw") String empPw,
			@RequestParam(value="newPw") String newPw, @RequestParam(value="newPwCon") String newPwCon) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		String pw = authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(empPw, pw)) {
			if(newPw.contentEquals(newPwCon)) {
				// 비밀번호변경
				newPw = bcryptPasswordEncoder.encode(newPw);
				employeePwChangeService.pwOk(userId, newPw);
				return "redirect:/";
				// **로그아웃을 하지 않으면 비밀번호가 바꾸기 전 그대로인 문제**
			}else {
				return "employee/pwChangeCnf";
			}
		}else {
			return "employee/pwChangeCnf";
		}	
	}
	
	@RequestMapping("empList")
	public String empList(Model model) {
		employeeListService.empList(model);
		return "employee/empList";
	}
	@RequestMapping("empReget")
	public String empReget(Model model) {
		employeeNoService.getEmpNo(model);
		return "employee/employeeForm";
	}
	@RequestMapping(value="empJoin", method=RequestMethod.POST)
	public String  empJoin(EmployeeCommand employeeCommand) {
		employeeService.insertEmp(employeeCommand);
		return "redirect:empList";
	}
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value="empNo") String empNo, Model model) {
		employeeInfoService.empInfo(empNo, model);
		System.out.println(empNo);
		return "employee/employeeInfo";
	}
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="empNo") String empNo, Model model) {
		employeeInfoService.empInfo(empNo, model);
		return "employee/employeeModify";
	}
	@RequestMapping("empModifyOk")
	public String empModifyOk(EmployeeCommand employeeCommand) {
		employeeModifyService.empModify(employeeCommand);
		return "redirect:empInfo?empNo="+employeeCommand.getEmpNo();
	}
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value="empNo") String empNo) {
		employeeDeleteService.empDelete(empNo);
		return "redirect:empList";
	}
}
