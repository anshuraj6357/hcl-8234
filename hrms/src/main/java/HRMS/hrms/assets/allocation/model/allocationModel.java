package HRMS.hrms.assets.allocation.model;


import HRMS.hrms.assets.asset.model.assetModel;
import HRMS.hrms.auth.model.authModelUser;
import HRMS.hrms.employee.model.employeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "asset_allocations")
@Getter
@Setter
public class allocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allocation_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    private assetModel asset_Id;

    // Employee module se employee ki ID
    @Column(name = "employee_id", nullable = false)
    private Long employee_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private employeeModel employee;

    @Column(nullable = false)
    private LocalDate allocation_Date;

    private LocalDate expected_ReturnDate;

    private LocalDate actual_ReturnDate;

    @Column(nullable = false, length = 30)
    private String allocation_Status = "ALLOCATED";

    @Column(length = 500)
    private String allocation_Purpose;

    // Asset issue karne wale authorized user ki ID
    @Column(name = "allocated_by")
    private Long allocated_By;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "allocated_by", referencedColumnName = "id",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private authModelUser allocatedByUser;

    @Column(length = 500)
    private String allocation_Remarks;

    @Column(nullable = false, updatable = false)
    private LocalDateTime allocation_CreatedAt;

    private LocalDateTime allocation_UpdatedAt;

    @PrePersist
    protected void onCreate() {
        allocation_CreatedAt = LocalDateTime.now();
        allocation_UpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        allocation_UpdatedAt = LocalDateTime.now();
    }
}