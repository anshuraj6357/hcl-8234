
package HRMS.hrms.employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class employeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee name
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 50,
            message = "First name must be between 2 and 50 characters")
    @Pattern(regexp = "^[\\p{L}][\\p{L} .'-]*$",
            message = "First name contains invalid characters")
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 50,
            message = "Last name must be between 2 and 50 characters")
    @Pattern(regexp = "^[\\p{L}][\\p{L} .'-]*$",
            message = "Last name contains invalid characters")
    @Column(nullable = false, length = 50)
    private String lastName;

    // Contact details
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please enter a valid email address")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits")
    @Column(nullable = false, length = 10)
    private String phoneNumber;

    // Employment details
    @NotBlank(message = "Department is mandatory")
    @Size(max = 50, message = "Department cannot exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String department;

    @NotBlank(message = "Designation is mandatory")
    @Size(max = 80, message = "Designation cannot exceed 80 characters")
    @Column(nullable = false, length = 80)
    private String designation;

    @NotNull(message = "Salary is mandatory")
    @DecimalMin(value = "0.0", inclusive = false,
            message = "Salary must be greater than zero")
    @Digits(integer = 10, fraction = 2,
            message = "Salary can have up to 10 integer digits and 2 decimal places")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal salary;

    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Joining date is mandatory")
    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate dateOfJoining;

    @NotBlank(message = "Employment type is mandatory")
    @Pattern(regexp = "FULL_TIME|PART_TIME|CONTRACT|INTERN",
            message = "Employment type must be FULL_TIME, PART_TIME, CONTRACT or INTERN")
    @Column(nullable = false, length = 20)
    private String employmentType;

    @NotBlank(message = "Employee status is mandatory")
    @Pattern(regexp = "ACTIVE|INACTIVE|ON_LEAVE|TERMINATED",
            message = "Status must be ACTIVE, INACTIVE, ON_LEAVE or TERMINATED")
    @Column(nullable = false, length = 20)
    private String status = "ACTIVE";

    // Address
    @NotBlank(message = "Address is mandatory")
    @Size(max = 250, message = "Address cannot exceed 250 characters")
    private String address;

    @NotBlank(message = "City is mandatory")
    @Size(max = 60, message = "City cannot exceed 60 characters")
    private String city;

    @NotBlank(message = "State is mandatory")
    @Size(max = 60, message = "State cannot exceed 60 characters")
    private String state;

    @NotBlank(message = "ZIP code is mandatory")
    @Pattern(regexp = "^[0-9]{6}$",
            message = "ZIP code must contain exactly 6 digits")
    @Column(nullable = false, length = 6)
    private String zip;

    @NotBlank(message = "Country is mandatory")
    @Size(max = 60, message = "Country cannot exceed 60 characters")
    private String country;

    @Pattern(regexp = "Male|Female|Other",
            message = "Gender must be Male, Female or Other")
    private String gender;

    // Optional profile photo URL
    @Size(max = 500, message = "Profile picture URL is too long")
    @Pattern(regexp = "^(https?://\\S+)?$",
            message = "Profile picture must be a valid HTTP or HTTPS URL")
    private String profilePicture;

    // Audit timestamps
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
