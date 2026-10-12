package hcl_day5.PractiseQuestion1;

import java.util.ArrayList;

public class updateEmployee {
    public void updateEmployee(ArrayList<Employee> e, int id, String name, double salary){
        boolean found =false;
        for(Employee e1:e){
            if(e1.id==id){
                found=true;
                e1.name=name;
                e1.salary=salary;
                return;
            }
        }
        if(!found){
            System.out.println("Employee not found");
        }
    }
}
