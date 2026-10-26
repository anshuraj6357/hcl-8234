package HRMS.hrms.organisation.branch.mapper;


import HRMS.hrms.organisation.branch.dto.branchRequestDto;
import HRMS.hrms.organisation.branch.dto.branchResponseDto;
import org.springframework.stereotype.Component;

@Component
public class brachToDtoMapper {


    public branchResponseDto toDto(branchRequestDto branchRequestDto) {
        branchResponseDto branchResponseDto = new branchResponseDto();
        branchResponseDto.setBranch_Code(branchRequestDto.getBranch_Code());
        branchResponseDto.setBranch_Name(branchRequestDto.getBranch_Name());
        branchResponseDto.setBranch_Pincode(branchRequestDto.getBranch_Pincode());
        branchResponseDto.setBranch_Active(branchRequestDto.getBranch_Active());
        branchResponseDto.setBranch_State(branchRequestDto.getBranch_State());
        branchResponseDto.setBranch_Address(branchRequestDto.getBranch_Address());
        branchResponseDto.setBranch_City(branchRequestDto.getBranch_City());
       return branchResponseDto;
    }
}
