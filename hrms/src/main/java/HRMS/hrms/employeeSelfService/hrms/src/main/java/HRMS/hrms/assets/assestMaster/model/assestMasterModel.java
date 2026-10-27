package HRMS.hrms.assets.assestMaster.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "asset_masters")
@Getter
@Setter
public class assestMasterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetMaster_Id;

    @Column(nullable = false, unique = true, length = 50)
    private String assetMaster_Code;

    @Column(nullable = false, length = 100)
    private String asset_Name;

    @Column(nullable = false, length = 100)
    private String asset_Category;

    @Column(length = 100)
    private String asset_Brand;

    @Column(length = 100)
    private String asset_Model;

    @Column(length = 500)
    private String asset_Description;

    @Column(length = 100)
    private String asset_Specifications;

    @Column(nullable = false)
    private Boolean assetMaster_Active = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime assetMaster_CreatedAt;

    private LocalDateTime assetMaster_UpdatedAt;

    @PrePersist
    protected void onCreate() {
        assetMaster_CreatedAt = LocalDateTime.now();
        assetMaster_UpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        assetMaster_UpdatedAt = LocalDateTime.now();
    }
}