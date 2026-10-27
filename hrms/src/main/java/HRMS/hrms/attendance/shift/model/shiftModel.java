package HRMS.hrms.attendance.shift.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hrms_shift")
@Getter
@Setter
public class shiftModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String shiftName;

    @Column(nullable = false)
    private String startTime; // HH:mm

    @Column(nullable = false)
    private String endTime; // HH:mm

    private Integer graceMinutes = 0;
    private Boolean active = true;
}
