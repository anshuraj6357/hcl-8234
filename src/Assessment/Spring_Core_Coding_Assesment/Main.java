package Assessment.Spring_Core_Coding_Assesment;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService service =
                context.getBean(StudentService.class);

        service.displayStudentProfile();

        context.close();
    }
}
