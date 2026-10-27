package HRMS.hrms.attendance.punch.model;

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
    @Column(nullable = false)
    private Long employeeId;
    @Column(nullable = false)
    private LocalDateTime punchTime;
    @Column(nullable = false)
    private String punchType; // IN or OUT
    private String source = "WEB";
    private String remarks;

}
