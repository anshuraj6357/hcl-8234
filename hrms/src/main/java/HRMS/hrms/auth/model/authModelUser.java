package HRMS.hrms.auth.model;

import HRMS.hrms.auth.enumRoles.roles;
import HRMS.hrms.organisation.company.model.companyModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class authModelUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password="1234";
    @Email
    @NotNull(message = "Email cannot be null")
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    private roles role;
    private Long otp=null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private companyModel companyId;

    private Long tokenCreatedAt;
    private Long tokenExpiresIn;
}
