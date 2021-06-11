package service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empInfo(String empNo, Model model) {
		EmployeeDTO dto = employeeRepository.empInfo(empNo);
		model.addAttribute("emp", dto);
	}

}
