package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.AuthInfo;
import repository.EmployeeRepository;

public class EmployeeDeleteOkService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void del(HttpSession session, String empPw1) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empPw = authInfo.getUserPw();
		String empNo = authInfo.getGrade();
		if(bcryptPasswordEncoder.matches(empPw1, empPw) ) {
			employeeRepository.empdelete(empNo);
		}
	}

}
