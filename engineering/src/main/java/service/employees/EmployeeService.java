package service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public void insertEmp(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpDeptNumber(employeeCommand.getEmpDeptNumber());;
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNo(employeeCommand.getEmpNo());
		dto.setEmpPhoneNumber(employeeCommand.getEmpPhoneNumber());
		dto.setEmpPw(bcryptPasswordEncoder.encode(
				employeeCommand.getEmpPw()));
		dto.setHireDate(employeeCommand.getHireDate());
		dto.setSalary(employeeCommand.getSalary());
		employeeRepository.insertEmployee(dto);
	}
}
