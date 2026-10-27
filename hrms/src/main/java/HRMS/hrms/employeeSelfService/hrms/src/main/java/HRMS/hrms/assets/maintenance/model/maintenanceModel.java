package HRMS.hrms.assets.maintenance.model;


import HRMS.hrms.assets.asset.model.assetModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "asset_maintenance")
@Getter
@Setter
public class maintenanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenance_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    private assetModel asset_Id;

    @Column(nullable = false, length = 30)
    private String maintenance_Type;

    @Column(nullable = false)
    private LocalDate maintenance_Date;

    private LocalDate maintenance_CompletionDate;

    @Column(length = 150)
    private String maintenance_Vendor;

    private Double maintenance_Cost;

    @Column(nullable = false, length = 30)
    private String maintenance_Status = "PENDING";

    @Column(length = 1000)
    private String maintenance_Description;

    @Column(length = 1000)
    private String maintenance_Remarks;

    private LocalDate next_MaintenanceDate;

    // Request create karne wale user ki ID
    private Long created_By;

    @Column(nullable = false, updatable = false)
    private LocalDateTime maintenance_CreatedAt;

    private LocalDateTime maintenance_UpdatedAt;

    @PrePersist
    protected void onCreate() {
        maintenance_CreatedAt = LocalDateTime.now();
        maintenance_UpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        maintenance_UpdatedAt = LocalDateTime.now();
    }
}