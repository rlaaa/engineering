package service.employees;

import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeePwChangeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void pwOk(String userId, String newPw) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(userId);
		dto.setEmpPw(newPw);
		employeeRepository.pwChange(dto);
	}

}
