package selfPractise.XmlBasedConfiguration.pom;

public class employee {
    private String name;
    private double salary;
    private int age;

    //paramaterised constructor
    public  employee(String name,double salary,int age){
            this.name=name;
            this.salary=salary;
            this.age=age;
    }

    //getter
    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }
    public int getAge(){
        return this.age;
    }

    //setter
    public void setName(String name){
        this.name=name;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String toString(){
        return this.name+" "+this.salary+" "+this.age;
    }

}
