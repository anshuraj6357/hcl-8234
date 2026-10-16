package module2.cunstructorDi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            Employee emp = context.getBean(Employee.class);

            emp.getEmpAddress();
        }
    }
}