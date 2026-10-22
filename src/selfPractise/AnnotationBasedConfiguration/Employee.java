package selfPractise.AnnotationBasedConfiguration;

public class Employee {
    private static int  counter=1001;

    private String name;
    private int salary;
    private double EmployeeId;
    private String Employeetype;

    //default constructor
    public Employee() {
        this.EmployeeId = counter++;
    }

    //parameterised constructor
    public Employee(String name, int salary,String Employeetype) {
        this.name = name;
        this.salary = salary;
        this.Employeetype = Employeetype;
    }
    //setter
    public void  setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }
    public void setEmployeetype(String Employeetype) {
        this.Employeetype = Employeetype;
    }
    //getter
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public double getEmployeeId() {
        return EmployeeId;
    }
    public String getEmployeetype() {
        return Employeetype;
    }
}
