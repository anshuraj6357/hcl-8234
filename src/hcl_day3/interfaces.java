package hcl_day3;

interface A {

    // Abstract method
    void show();

    // Static method
    static void display() {
        System.out.println("This is a static method of Interface A");
    }
}

// Implementing interface
class B implements A {

    @Override
    public void show() {
        System.out.println("This is implemented method of Class B");
    }
}

public class interfaces {

    public static void main(String[] args) {

        // Creating object of class B
        B obj = new B();

        // Calling implemented method
        obj.show();

        // Calling interface static method
        A.display();
    }
}