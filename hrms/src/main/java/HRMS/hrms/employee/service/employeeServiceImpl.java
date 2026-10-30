package HRMS.hrms.employee.service;

import HRMS.hrms.employee.dto.employeeDto;
import HRMS.hrms.employee.exception.employeeNotFound;
import HRMS.hrms.employee.mapper.employeeMapper;
import HRMS.hrms.employee.model.employeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import HRMS.hrms.employee.repository.employeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService {

    @Autowired
    private employeeRepo employeeRepo;
    @Autowired
    private employeeMapper employeeMapper;

    public employeeDto createEmployee(employeeDto employee) {
        employeeModel newEmployee=employeeMapper.toEntity(employee);
        employeeModel savedEmployee = employeeRepo.save(newEmployee);
        return employeeMapper.toDto(savedEmployee);
    }

    public employeeDto getEmployeeById(Long id) throws employeeNotFound {
        // Implementation for getting an employee by ID
        employeeModel employee=employeeRepo.findById(id).orElseThrow(() ->
                new employeeNotFound("Employee not found with ID: " + id));
        employeeDto dto= employeeMapper.toDto(employee);
        return dto;
    }

    public void deleteEmployee(Long id) throws employeeNotFound {
        // Implementation for deleting an employee
        employeeModel employee=employeeRepo.findById(id).orElseThrow(()->
                new employeeNotFound("Employee not found with ID: " + id));
        employeeRepo.delete(employee);
    }

    public void updateEmployee(Long id, employeeDto employee) throws employeeNotFound {
        // Implementation for updating an employee
        employeeModel existingEmployee = employeeRepo.findById(id).orElseThrow(() ->
                new employeeNotFound("Employee not found with ID: " + id));
        if (existingEmployee != null) {
            employeeMapper.updateEntity(employee, existingEmployee);
            employeeRepo.save(existingEmployee);
        }
    }

    public List<employeeDto> getAllEmployees() throws employeeNotFound {
        // Implementation for getting all employees
        List<employeeModel> employee=employeeRepo.findAll();
        if (employee.isEmpty()) {
            throw new employeeNotFound("No employees found");
        }
        return employee.stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    public List<employeeDto> getEmployeesByDepartment(String department) throws employeeNotFound {
        return employeeRepo.findByDepartment(department).stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    public List<employeeDto> getEmployeesByDesignation(String designation) throws employeeNotFound {
        return employeeRepo.findByDesignation(designation).stream()
                .map(employeeMapper::toDto)
                .toList();
    }
}
