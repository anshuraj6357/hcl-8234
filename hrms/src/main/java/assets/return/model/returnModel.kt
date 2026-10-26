package assets.`return`.model


import HRMS.hrms.organisation.assets.allocation.model.allocationModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "asset_returns")
@Getter
@Setter
public class returnModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long return_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "allocation_id", nullable = false)
    private allocationModel allocation_Id;

    @Column(nullable = false)
    private LocalDate return_Date;

    @Column(nullable = false, length = 30)
    private String return_Condition;

    @Column(nullable = false, length = 30)
    private String return_Status = "RECEIVED";

    @Column(length = 1000)
    private String return_Remarks;

    // Asset receive karne wale user ki ID
    private Long received_By;

    private Boolean accessories_Returned = true;

    @Column(length = 500)
    private String missing_Items;

    @Column(nullable = false, updatable = false)
    private LocalDateTime return_CreatedAt;

    @PrePersist
    protected void onCreate() {
        return_CreatedAt = LocalDateTime.now();
    }
}