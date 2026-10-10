package hcl_day2;

public class ConstructrOverLoading {
    int age;
    String name;
    int year;
    int month;


    ConstructrOverLoading(String name, int age) {
        this.name = name;
        this.age = age;
    }
    ConstructrOverLoading(String name, int age,int year,int month) {
        this.name = name;
        this.age = age;
        this.year=year;
        this.month=month;
    }

    public static void main(String[] args) {

        ConstructrOverLoading s = new ConstructrOverLoading("Anshu", 22);
        ConstructrOverLoading sm = new ConstructrOverLoading("Anshu", 23,2021,4);

        System.out.println(s.name);
        System.out.println(sm.age);
        System.out.println(sm.month);
    }
}