
package HRMS.hrms.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class employeeDto {
    private Long id;
//    @NotBlank(message = "First name is mandatory")
//    @Size(min = 2, max = 50,
//            message = "First name must be between 2 and 50 characters")
    private String firstName;

//    @NotBlank(message = "Last name is mandatory")
//    @Size(min = 2, max = 50,
//            message = "Last name must be between 2 and 50 characters")
    private String lastName;

//    @NotBlank(message = "Email is mandatory")
//    @Email(message = "Please enter a valid email")
    private String email;

//    @NotBlank(message = "Phone number is mandatory")
//    @Pattern(regexp = "^[0-9]{10}$",
//            message = "Phone number must contain exactly 10 digits")
    private String phoneNumber;

//    @NotNull(message = "Salary is mandatory")
//    @DecimalMin(value = "0.0", inclusive = false,
//            message = "Salary must be greater than zero")
//    @Digits(integer = 10, fraction = 2,
//            message = "Salary can have up to 10 integer digits and 2 decimal places")
    private BigDecimal salary;

//    @NotBlank(message = "Department is mandatory")
    private String department;

//    @NotBlank(message = "Designation is mandatory")
    private String designation;

//    @NotNull(message = "Date of birth is mandatory")
//    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

//    @NotNull(message = "Joining date is mandatory")
//    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate dateOfJoining;

//    @NotBlank(message = "Employment type is mandatory")
//    @Pattern(regexp = "^(FULL_TIME|PART_TIME|CONTRACT|INTERN)$",
//            message = "Invalid employment type")
    private String employmentType;

//    @NotBlank(message = "Address is mandatory")
    private String address;

//    @NotBlank(message = "City is mandatory")
    private String city;

//    @NotBlank(message = "State is mandatory")
    private String state;

//    @NotBlank(message = "ZIP code is mandatory")
//    @Pattern(regexp = "^[0-9]{6}$",
//            message = "ZIP code must contain exactly 6 digits")
    private String zip;

//    @NotBlank(message = "Country is mandatory")
    private String country;

    private String gender;

    private String profilePicture;
}
