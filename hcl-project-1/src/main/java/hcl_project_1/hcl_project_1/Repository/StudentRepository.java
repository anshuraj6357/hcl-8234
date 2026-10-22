package hcl_project_1.hcl_project_1.Repository;

import hcl_project_1.hcl_project_1.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student save(Student student);
    public Optional<Student> findById(Integer id);


}
