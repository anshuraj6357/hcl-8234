package hcl_day2;

public class constructorcreated {

    int age;
    String name;


    constructorcreated(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        constructorcreated s = new constructorcreated("Anshu", 22);

        System.out.println(s.name);
        System.out.println(s.age);
    }
}