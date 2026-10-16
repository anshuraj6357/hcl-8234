package module2.cunstructorDi;

public class Employee {

    private final module2.cunstructorDi.Adress address;

    // Constructor Dependency Injection
    public Employee(module2.cunstructorDi.Adress address) {
        this.address = address;
    }

    public void getEmpAddress() {
        System.out.println("Employee Address:");
        address.getAddress();
    }
}