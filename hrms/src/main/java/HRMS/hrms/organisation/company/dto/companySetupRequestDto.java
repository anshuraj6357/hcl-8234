package HRMS.hrms.organisation.company.dto;

import HRMS.hrms.auth.dto.authUserRequestDto;
import HRMS.hrms.auth.model.authModelUser;
import HRMS.hrms.organisation.location.dto.locationRequestDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class companySetupRequestDto {

    private companyRequestDto companyRequestDto;
    private locationRequestDto locationRequestDto;
    private authModelUser authUserRequestDto;
}
