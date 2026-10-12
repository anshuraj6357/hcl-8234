package module1.PractiseQuestion1;

import java.util.ArrayList;

public class addEmployee {

    public void add(ArrayList<Employee> employees,
                    int id, String name, double salary) {

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully");
    }
}