package hcl_project_1.hcl_project_1.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    @ElementCollection
    @CollectionTable(
            name="student_courses",
            joinColumns = @JoinColumn(name="student_id")
    )
    @Column(name="courses")
    private List<String> courses;

    // Required by JPA
    public Student() {}

    public Student(String name, String surname, String email, List<String> courses) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        setCourses(courses);
    }

    public void setCourses(List<String> courses) {
        if (courses == null) {
            throw new NullPointerException("courses must not be null");
        }

        this.courses = new ArrayList<>(courses);
    }
}
