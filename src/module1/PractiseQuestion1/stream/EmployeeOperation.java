package module1.PractiseQuestion1.stream;

import java.util.ArrayList;
import java.util.stream.Collectors;

class Employee{
    String name;
    int age;
    double Salary;
    public Employee(String name, int age, double Salary){
        this.name = name;
        this.age = age;
        this.Salary = Salary;
    }
}

public class EmployeeOperation {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList();
        list.add(new Employee("Jack", 18, 500.00));
        list.add(new Employee("John", 21, 1000.00));
        list.add(new Employee("Jane", 22, 1500.00));
        list.add(new Employee("Rahul", 25, 2500.00));
        list.add(new Employee("Priya", 24, 3200.00));
        list.add(new Employee("Amit", 28, 4500.00));
        list.add(new Employee("Sneha", 26, 3800.00));
        list.add(new Employee("Rohit", 30, 5500.00));
        list.add(new Employee("Anjali", 23, 2800.00));
        list.add(new Employee("Vikram", 35, 7500.00));
        list.add(new Employee("Neha", 27, 4200.00));
        list.add(new Employee("Karan", 32, 6200.00));
        list.add(new Employee("Pooja", 29, 4800.00));
        list.add(new Employee("Arjun", 31, 5800.00));
        ArrayList<Employee> result =      list.stream().filter(x->x.Salary>5000)
                .collect(Collectors.toCollection());
    }



}
