package hcl_day5.PractiseQuestion1;

import java.util.ArrayList;
import java.util.Comparator;

public class sortSalary {
    public void increasingSalary(ArrayList<Employee> employees) {

        employees.sort(
                Comparator.comparingDouble(e->e.salary)
        );
        System.out.println("Employees sorted by salary");
        for (Employee e: employees) {
            System.out.println(e.name);
            System.out.println(e.salary);
            System.out.println(e.id);
        }
    }
}
