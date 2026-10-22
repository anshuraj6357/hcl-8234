
package hcl_project_1.hcl_project_1.ServiceImplementation;

import hcl_project_1.hcl_project_1.Exception.StudentNotFound;
import hcl_project_1.hcl_project_1.Model.Student;
import hcl_project_1.hcl_project_1.Repository.StudentRepository;
import hcl_project_1.hcl_project_1.Service.StudentService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student CreateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student GetStudentById(Integer id) throws StudentNotFound {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFound(
                                "Student with id " + id + " not found"
                        )
                );
    }

    @Override
    public List<Student> GetAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student UpdateStudent(Integer id, Student student) throws StudentNotFound{
        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFound(
                                "Student with id " + id + " not found"
                        )
                );

        if (student.getName() == null
                || student.getSurname() == null
                || student.getEmail() == null
                || student.getCourses() == null) {
            throw new IllegalArgumentException(
                    "Student details cannot be null"
            );
        }

        foundStudent.setName(student.getName());
        foundStudent.setSurname(student.getSurname());
        foundStudent.setEmail(student.getEmail());
        foundStudent.setCourses(student.getCourses());

        return studentRepository.save(foundStudent);
    }

    @Override
    public void DeleteStudent(Integer id) throws  StudentNotFound {
        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFound(
                                "Student with id " + id + " not found"
                        )
                );

        studentRepository.delete(foundStudent);
    }
}
