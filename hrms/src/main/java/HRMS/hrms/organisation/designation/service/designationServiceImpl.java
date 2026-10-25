package HRMS.hrms.organisation.designation.service;


import HRMS.hrms.organisation.designation.dto.designationRequestDto;
import HRMS.hrms.organisation.designation.dto.designationResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class designationServiceImpl implements designationService{



    public designationResponseDto createDesignation(
            designationRequestDto designationRequestDto
    ){
        return null;
    }

    @Override
    public List<designationResponseDto> getAllDesignations() {
        return List.of();
    }

    public designationResponseDto getDesignationById(Long id){
        return null;
    }

    public designationResponseDto updateDesignation(
            Long id,
            designationRequestDto designationRequestDto
    ){
        return null;
    }

    public   void deleteDesignation(Long id){

    }

    public List<designationResponseDto> getDesignationsByDepartmentId(
            Long departmentId
    ){
        return null;
    }

}
