package Assessment.Spring_Core_Coding_Assesment;


public class StudentService {

    private final Student student;

    public StudentService(Student student) {
        this.student = student;
    }

    public void displayStudentProfile() {
        student.displayStudent();
    }
}
