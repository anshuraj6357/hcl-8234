package HRMS.hrms.auth.dto;


import HRMS.hrms.auth.enumRoles.roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class sendOtpdto {
    private String email;
    private roles role;
}
