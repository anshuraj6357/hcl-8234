//package selfPractise.AnnotationBasedConfiguration;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        try (AnnotationConfigApplicationContext context =
//                     new AnnotationConfigApplicationContext(AppConfig.class)) {
//
//            PayRollService payRollService =
//                    context.getBean(PayRollService.class);
//
//            Employee e = new Employee("Rahul", "FullTime");
//
//            payRollService.ProcessSalary(e);
//
//            System.out.println("Employee Name: " + e.getName());
//            System.out.println("Salary: " + e.getSalary());
//        }
//    }
//}