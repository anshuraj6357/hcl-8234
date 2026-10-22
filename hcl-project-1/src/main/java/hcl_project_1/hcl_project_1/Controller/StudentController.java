package hcl_project_1.hcl_project_1.Controller;

import hcl_project_1.hcl_project_1.Exception.StudentNotFound;
import hcl_project_1.hcl_project_1.Model.Student;
import hcl_project_1.hcl_project_1.Service.StudentService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiv1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    @CacheEvict(cacheNames = "students", allEntries = true)
    public ResponseEntity<Student> CreateStudent(@RequestBody Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Surname: " + student.getSurname());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Courses: " + student.getCourses());
        Student savedStudent = studentService.CreateStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }


    @GetMapping("/getAllStudents")
    @Cacheable(cacheNames = "students", key = "'all'")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.GetAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getStudent/{id}")
    @Cacheable(cacheNames = "students", key = "#id")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) throws StudentNotFound {
        return ResponseEntity.ok(studentService.GetStudentById(id));
    }

    @PutMapping("/updateStudent/{id}")
    @CacheEvict(cacheNames = "students", allEntries = true)
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) throws StudentNotFound {
        Student updatedStudent = studentService.UpdateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/deleteStudent/{id}")
    @CacheEvict(cacheNames = "students", allEntries = true)
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) throws StudentNotFound {
        studentService.DeleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
