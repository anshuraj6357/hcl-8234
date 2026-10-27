
        package HRMS.hrms.organisation.location.model;

import HRMS.hrms.organisation.company.model.companyModel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
@Getter
@Setter
public class locationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long location_Id;

    // Location identification
    @Column(nullable = false, unique = true)
    private String location_Code;

    @Column(nullable = false)
    private String location_Name;

    // Company relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private companyModel company_Id;

    // Address details
    @Column(nullable = false, length = 500)
    private String location_Address;

    @Column(nullable = false)
    private String location_City;

    @Column(nullable = false)
    private String location_State;

    @Column(nullable = false)
    private String location_Country;

    @Column(nullable = false, length = 10)
    private String location_Pincode;

    // Optional geographical details
    private Double location_Latitude;

    private Double location_Longitude;

    // Status
    @Column(nullable = false)
    private Boolean location_Active = true;

    // Audit details
    @Column(nullable = false, updatable = false)
    private LocalDateTime location_CreatedAt;

    private LocalDateTime location_UpdatedAt;

    @PrePersist
    protected void onCreate() {
        location_CreatedAt = LocalDateTime.now();
        location_UpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        location_UpdatedAt = LocalDateTime.now();
    }
}
