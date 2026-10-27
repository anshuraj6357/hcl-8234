package HRMS.hrms.assets.conditions.model;


import HRMS.hrms.assets.asset.model.assetModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "asset_conditions")
@Getter
@Setter
public class conditionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long condition_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    private assetModel asset_Id;

    @Column(nullable = false, length = 30)
    private String condition_Status;

    @Column(length = 1000)
    private String condition_Remarks;

    @Column(nullable = false)
    private LocalDateTime condition_CheckedAt;

    // Inspection karne wale user ki ID
    private Long checked_By;

    @Column(length = 500)
    private String condition_DamageDetails;

    @PrePersist
    protected void onCreate() {
        if (condition_CheckedAt == null) {
            condition_CheckedAt = LocalDateTime.now();
        }
    }
}