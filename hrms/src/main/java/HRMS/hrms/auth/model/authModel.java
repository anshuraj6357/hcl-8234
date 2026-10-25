package HRMS.hrms.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class authModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="Password cannot be null")
    @NotNull
    private String password;
    @Email
    @NotBlank(message="Email cannot be blank")
    @NotNull
    private String email;
    @NotBlank(message = "Role cannot be blank")
    private String role;
    @NotBlank(message = "Confirm Password cannot be blank")
    private String confermPassword;
    private Long otp;
}
