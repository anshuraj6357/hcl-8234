package HRMS.hrms.organisation.designation.model;


import HRMS.hrms.organisation.department.model.departmentModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "designations")
public class designationModel {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long designation_Id;

        @Column(nullable = false)
        private String designation_Name;

        @Column(nullable = false, unique = true)
        private String designation_Code;

        private String designation_Description;

        @Column(nullable = false)
        private Boolean designation_Active = true;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_id", nullable = false)
        private departmentModel department;


}
