package HRMS.hrms.auth.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class authUserRequestDto {


    private String password;
    private String confermPassword;
    private String email;
    private String role;
    private Long otp;
}
