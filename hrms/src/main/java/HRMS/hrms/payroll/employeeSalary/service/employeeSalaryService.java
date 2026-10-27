package HRMS.hrms.payroll.employeeSalary.service;

import HRMS.hrms.payroll.employeeSalary.dto.employeeSalaryRequestDto;
import HRMS.hrms.payroll.employeeSalary.dto.employeeSalaryResponseDto;

import java.util.List;

public interface employeeSalaryService {

    employeeSalaryResponseDto createEmployeeSalary(
            employeeSalaryRequestDto dto);

    List<employeeSalaryResponseDto> getAllEmployeeSalaries();

    employeeSalaryResponseDto getEmployeeSalaryById(Long id);

    List<employeeSalaryResponseDto> getSalariesByEmployeeId(
            Long employeeId);

    employeeSalaryResponseDto updateEmployeeSalary(
            Long id, employeeSalaryRequestDto dto);

    void deleteEmployeeSalary(Long id);
}