package HRMS.hrms.employee.service;

import HRMS.hrms.employee.dto.employeeDto;
import HRMS.hrms.employee.exception.employee.employeeNotFound;

import java.util.List;

public interface employeeService {

    public employeeDto createEmployee(employeeDto employee);
    public employeeDto getEmployeeById(Long id) throws employeeNotFound;
    public void deleteEmployee(Long id) throws employeeNotFound;
    public void updateEmployee(Long id, employeeDto employee) throws employeeNotFound;
    public List<employeeDto> getAllEmployees() throws employeeNotFound;
    public List<employeeDto> getEmployeesByDepartment(String department) throws employeeNotFound;
    public List<employeeDto> getEmployeesByDesignation(String designation) throws employeeNotFound;
}
