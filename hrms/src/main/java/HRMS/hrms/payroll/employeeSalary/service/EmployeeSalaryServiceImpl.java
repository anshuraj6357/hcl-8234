
package HRMS.hrms.payroll.employeeSalary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import HRMS.hrms.payroll.employeeSalary.dto.employeeSalaryRequestDto;
import HRMS.hrms.payroll.employeeSalary.dto.employeeSalaryResponseDto;
import HRMS.hrms.payroll.employeeSalary.mapper.employeeSalaryToDtoMapper;
import HRMS.hrms.payroll.employeeSalary.mapper.employeeSalaryToEntityMapper;
import HRMS.hrms.payroll.employeeSalary.model.employeeSalaryModel;
import HRMS.hrms.payroll.employeeSalary.repository.employeeSalaryRepository;

import HRMS.hrms.payroll.salarystructure.model.salaryStructureModel;
import HRMS.hrms.payroll.salarystructure.repository.salaryStructureRepository;

import java.util.List;

@Service
public class EmployeeSalaryServiceImpl implements employeeSalaryService {

    @Autowired
    private  employeeSalaryToDtoMapper employeeSalarytoDtoMapper;
    private  employeeSalaryToEntityMapper employeeSalaryToEntityMapper;
    private  employeeSalaryRepository employeeSalaryRepository;
    private  salaryStructureRepository salaryStructureRepository;


    // 1. Create Employee Salary
    @Override
    public employeeSalaryResponseDto createEmployeeSalary(
            employeeSalaryRequestDto dto) {

        salaryStructureModel structure =
                salaryStructureRepository.findById(dto.getSalaryStructureId())
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Salary structure not found"));

        employeeSalaryModel employeeSalary =
                employeeSalaryToEntityMapper.toEntity(dto);

        employeeSalary.setSalaryStructure(structure);

        employeeSalaryModel saved =
                employeeSalaryRepository.save(employeeSalary);

        return employeeSalarytoDtoMapper.toDto(saved);
    }

    // 2. Get All Employee Salaries
    @Override
    @Transactional(readOnly = true)
    public List<employeeSalaryResponseDto> getAllEmployeeSalaries() {

        List<employeeSalaryModel> employees =
                employeeSalaryRepository.findAll();

        if (employees.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No employee salary records found");
        }

        return employees.stream()
                .map(employeeSalarytoDtoMapper::toDto)
                .toList();
    }

    // 3. Get Employee Salary By ID
    @Override
    @Transactional(readOnly = true)
    public employeeSalaryResponseDto getEmployeeSalaryById(Long id) {

        employeeSalaryModel employeeSalary =
                employeeSalaryRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee salary not found with ID: " + id));

        return employeeSalarytoDtoMapper.toDto(employeeSalary);
    }

    // 4. Get Salaries By Employee ID
    @Override
    @Transactional(readOnly = true)
    public List<employeeSalaryResponseDto> getSalariesByEmployeeId(
            Long employeeId) {

        List<employeeSalaryModel> salaries =
                employeeSalaryRepository.findByEmployeeId(employeeId);

        if (salaries.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No salary records found for employee ID: " + employeeId);
        }

        return salaries.stream()
                .map(employeeSalarytoDtoMapper::toDto)
                .toList();
    }

    // 5. Update Employee Salary
    @Override
    public employeeSalaryResponseDto updateEmployeeSalary(
            Long id,
            employeeSalaryRequestDto dto) {

        employeeSalaryModel existingSalary =
                employeeSalaryRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee salary not found with ID: " + id));

        salaryStructureModel structure =
                salaryStructureRepository.findById(dto.getSalaryStructureId())
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Salary structure not found"));

        employeeSalaryModel updatedSalary =
                employeeSalaryToEntityMapper.toEntity(dto);

        existingSalary.setEmployeeId(updatedSalary.getEmployeeId());
        existingSalary.setSalaryStructure(structure);

        existingSalary.setEmployeeSalary_GrossSalary(
                updatedSalary.getEmployeeSalary_GrossSalary());

        existingSalary.setEmployeeSalary_EffectiveFrom(
                updatedSalary.getEmployeeSalary_EffectiveFrom());

        existingSalary.setEmployeeSalary_EffectiveTo(
                updatedSalary.getEmployeeSalary_EffectiveTo());

        if (dto.getEmployeeSalary_Active() != null) {
            existingSalary.setEmployeeSalary_Active(
                    dto.getEmployeeSalary_Active());
        }

        employeeSalaryModel saved =
                employeeSalaryRepository.save(existingSalary);

        return employeeSalarytoDtoMapper.toDto(saved);
    }

    // 6. Delete / Deactivate Employee Salary
    @Override
    public void deleteEmployeeSalary(Long id) {

        employeeSalaryModel employeeSalary =
                employeeSalaryRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee salary not found with ID: " + id));

        // Preserve salary history instead of permanently deleting it.
        employeeSalary.setEmployeeSalary_Active(false);

        employeeSalaryRepository.save(employeeSalary);
    }
}
