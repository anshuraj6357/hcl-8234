package HRMS.hrms.attendance.punch.model;

import HRMS.hrms.employee.model.employeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "hrms_punch")
@Getter
@Setter
public class punchModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",
        insertable = false, updatable = false,
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private employeeModel employee;
    @Column(nullable = false)
    private LocalDateTime punchTime;
    @Column(nullable = false)
    private String punchType; // IN or OUT
    private String source = "WEB";
    private String remarks;

}
