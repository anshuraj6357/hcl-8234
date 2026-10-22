package HRMS.hrms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class userModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="Password cannot be null")
    private String Password;
    @Email
    @NotBlank(message="Email cannot be blank")
    private String email;
    @NotBlank(message = "Role cannot be blank")
    private String role;
    @NotBlank(message = "Confirm Password cannot be blank")
    private String ConfermPassword;
    @NotBlank(message = "OTP cannot be blank")
    private String otp;
}
