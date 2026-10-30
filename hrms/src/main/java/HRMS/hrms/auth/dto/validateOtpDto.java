package HRMS.hrms.auth.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class validateOtpDto {
    private Long otp;
    private String email;
}
