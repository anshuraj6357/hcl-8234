
package HRMS.hrms.employee.mapper;

import HRMS.hrms.employee.dto.employeeDto;
import HRMS.hrms.employee.model.employeeModel;
import org.springframework.stereotype.Component;

@Component
public class employeeMapper {

    // 1. Entity -> DTO (GET response)

    public employeeDto toDto(employeeModel employee) {

        employeeDto dto = new employeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setSalary(employee.getSalary());
        dto.setDepartment(employee.getDepartment());
        dto.setDesignation(employee.getDesignation());
        dto.setDateOfBirth(employee.getDateOfBirth());
        dto.setDateOfJoining(employee.getDateOfJoining());
        dto.setEmploymentType(employee.getEmploymentType());
        dto.setStatus(employee.getStatus());
        dto.setAddress(employee.getAddress());
        dto.setCity(employee.getCity());
        dto.setState(employee.getState());
        dto.setZip(employee.getZip());
        dto.setCountry(employee.getCountry());
        dto.setGender(employee.getGender());
        dto.setProfilePicture(employee.getProfilePicture());

        return dto;
    }


    // 2. DTO -> Entity (CREATE employee)

    public employeeModel toEntity(employeeDto dto) {

        employeeModel employee = new employeeModel();

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(dto.getDepartment());
        employee.setDesignation(dto.getDesignation());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setDateOfJoining(dto.getDateOfJoining());
        employee.setEmploymentType(dto.getEmploymentType());
        if (dto.getStatus() != null) {
            employee.setStatus(dto.getStatus());
        }
        employee.setAddress(dto.getAddress());
        employee.setCity(dto.getCity());
        employee.setState(dto.getState());
        employee.setZip(dto.getZip());
        employee.setCountry(dto.getCountry());
        employee.setGender(dto.getGender());
        employee.setProfilePicture(dto.getProfilePicture());

        return employee;
    }


    // 3. Update existing Entity (UPDATE employee)

    public void updateEntity(employeeDto dto, employeeModel employee) {

        if (dto.getFirstName() != null) {
            employee.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            employee.setLastName(dto.getLastName());
        }

        if (dto.getEmail() != null) {
            employee.setEmail(dto.getEmail());
        }

        if (dto.getPhoneNumber() != null) {
            employee.setPhoneNumber(dto.getPhoneNumber());
        }

        if (dto.getSalary() != null) {
            employee.setSalary(dto.getSalary());
        }

        if (dto.getDepartment() != null) {
            employee.setDepartment(dto.getDepartment());
        }

        if (dto.getDesignation() != null) {
            employee.setDesignation(dto.getDesignation());
        }

        if (dto.getDateOfBirth() != null) {
            employee.setDateOfBirth(dto.getDateOfBirth());
        }

        if (dto.getDateOfJoining() != null) {
            employee.setDateOfJoining(dto.getDateOfJoining());
        }

        if (dto.getEmploymentType() != null) {
            employee.setEmploymentType(dto.getEmploymentType());
        }

        if (dto.getStatus() != null) {
            employee.setStatus(dto.getStatus());
        }

        if (dto.getAddress() != null) {
            employee.setAddress(dto.getAddress());
        }

        if (dto.getCity() != null) {
            employee.setCity(dto.getCity());
        }

        if (dto.getState() != null) {
            employee.setState(dto.getState());
        }

        if (dto.getZip() != null) {
            employee.setZip(dto.getZip());
        }

        if (dto.getCountry() != null) {
            employee.setCountry(dto.getCountry());
        }

        if (dto.getGender() != null) {
            employee.setGender(dto.getGender());
        }

        if (dto.getProfilePicture() != null) {
            employee.setProfilePicture(dto.getProfilePicture());
        }
    }

}
