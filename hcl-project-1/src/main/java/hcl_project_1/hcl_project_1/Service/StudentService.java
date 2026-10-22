package hcl_project_1.hcl_project_1.Service;

import hcl_project_1.hcl_project_1.Exception.StudentNotFound;
import hcl_project_1.hcl_project_1.Model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> GetAllStudents();
    public Student GetStudentById(Integer id) throws StudentNotFound;
    public Student CreateStudent(Student student);
    public Student UpdateStudent(Integer id, Student student) throws StudentNotFound;
    public void DeleteStudent(Integer id) throws  StudentNotFound;
}
