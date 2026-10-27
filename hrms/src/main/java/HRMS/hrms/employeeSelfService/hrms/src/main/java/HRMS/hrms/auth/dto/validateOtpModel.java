package HRMS.hrms.auth.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class validateOtpModel {
    private String email;
    private Long otp;
}
