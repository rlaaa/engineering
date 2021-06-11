package service.employees;

import org.springframework.beans.factory.annotation.Autowired;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeModifyService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empModify(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNo(employeeCommand.getEmpNo());
		dto.setEmpDeptNumber(employeeCommand.getEmpDeptNumber());	
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpPhoneNumber(employeeCommand.getEmpPhoneNumber());
		dto.setHireDate(employeeCommand.getHireDate());
		dto.setSalary(employeeCommand.getSalary());
		employeeRepository.empUpdate(dto);
	}
}
