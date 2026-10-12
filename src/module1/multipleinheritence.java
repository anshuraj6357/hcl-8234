package module1;

// First Interface
interface A1 {
    void show();
}

// Second Interface
interface B1 {
    void display();
}

// Multiple Inheritance
class C implements A1, B1 {

    @Override
    public void show() {
        System.out.println("This is Interface A");
    }

    @Override
    public void display() {
        System.out.println("This is Interface B");
    }
}

public class multipleinheritence
{

    public static void main(String[] args) {

        C obj = new C();

        obj.show();
        obj.display();
    }
}