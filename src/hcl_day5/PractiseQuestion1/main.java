
package hcl_day5.PractiseQuestion1;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        addEmployee add = new addEmployee();
        getEmployee read = new getEmployee();
        updateEmployee update = new updateEmployee();

//
//        IteratorEmployee iterator = new IteratorEmployee();
//        ListIteratorEmployee listIterator = new ListIteratorEmployee();
        sortSalary sort = new sortSalary();

        // CREATE
        add.add(employees, 101, "Rahul", 3500);
        add.add(employees, 102, "Anshu", 5000);
        add.add(employees, 103, "Rohit", 7500);

        // READ
        System.out.println("\nAll Employees:");
        read.getEmployee(employees);

        // UPDATE
        update.updateEmployee(employees, 101, "Rahul Kumar", 9000);

        // DELETE
//        delete.delete(employees, 103);

        // ITERATOR
//        System.out.println("\nIterator:");
//        iterator.display(employees);

        // LIST ITERATOR
//        System.out.println("\nListIterator:");
//        listIterator.display(employees);

        // SORTING
        System.out.println("All Salary increasing Sorted Employees");
        sort.increasingSalary(employees);
//        sort.decreasing(employees);
    }
}
