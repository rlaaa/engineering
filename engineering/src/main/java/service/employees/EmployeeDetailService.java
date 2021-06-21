package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeDetailService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empInfo(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNo = authInfo.getGrade();
		EmployeeDTO dto = employeeRepository.empInfo(empNo);
		model.addAttribute("emp", dto);
		
	}
	
}
