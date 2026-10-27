package HRMS.hrms.assets.asset.model;

import HRMS.hrms.assets.assestMaster.model.assestMasterModel;
import HRMS.hrms.organisation.location.model.locationModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "HRMS/hrms/assets")
@Getter
@Setter
public class assetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asset_Id;

    @Column(nullable = false, unique = true, length = 50)
    private String asset_Code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_master_id", nullable = false)
    private assestMasterModel assetMaster_Id;

    @Column(length = 100, unique = true)
    private String asset_SerialNumber;

    @Column(length = 100)
    private String asset_TagNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private locationModel location_Id;

    private LocalDate asset_PurchaseDate;

    private Double asset_PurchaseCost;

    private LocalDate asset_WarrantyExpiryDate;

    @Column(nullable = false, length = 30)
    private String asset_Status = "AVAILABLE";

    @Column(length = 500)
    private String asset_Remarks;

    @Column(nullable = false, updatable = false)
    private LocalDateTime asset_CreatedAt;

    private LocalDateTime asset_UpdatedAt;

    @PrePersist
    protected void onCreate() {
        asset_CreatedAt = LocalDateTime.now();
        asset_UpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        asset_UpdatedAt = LocalDateTime.now();
    }
}