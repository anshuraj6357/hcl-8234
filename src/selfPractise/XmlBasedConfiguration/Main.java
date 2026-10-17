package selfPractise.XmlBasedConfiguration.pom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext(
                             "selfPractise/XmlBasedConfiguration/pom/config.xml")) {

            employee e = context.getBean(
                    "EmployeeField", employee.class);

            System.out.println(e);
        }
    }
}