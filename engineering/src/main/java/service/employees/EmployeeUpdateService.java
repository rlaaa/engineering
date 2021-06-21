package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import command.EmployeeCommand;
import model.AuthInfo;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeUpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public int empUpdate(EmployeeCommand employeeCommand, HttpSession session) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpDeptNumber(employeeCommand.getEmpDeptNumber());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpPhoneNumber(employeeCommand.getEmpPhoneNumber());
		dto.setSalary(employeeCommand.getSalary());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setEmpId(authInfo.getUserId());		
		if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), authInfo.getUserPw())) {			
			employeeRepository.empUpdate(dto);
			session.removeAttribute("pwFail1");
			return 1;
		} else {
			session.setAttribute("pwFail1", "비밀번호가 일치하지 않습니다.");
			return 2;
		}
	}
}
