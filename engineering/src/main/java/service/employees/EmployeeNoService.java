package service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import repository.EmployeeRepository;

public class EmployeeNoService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void getEmpNo(Model model) {
		int empNo = employeeRepository.getEmpNo();//10001
		model.addAttribute("empNo1", empNo);
	}
}
