package controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employees.EmployeeDeleteService;
import service.employees.EmployeeInfoService;
import service.employees.EmployeeListService;
import service.employees.EmployeeModifyService;
import service.employees.EmployeeNoService;
import service.employees.EmployeeService;

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
