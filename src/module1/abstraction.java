package module1;

public class abstraction {

    abstract class A {
        void Show() {
            System.out.println("This is Class A");
        }
    }

    class B extends A {

        @Override
        void Show() {
            System.out.println("This is Class B");
        }
    }

    public static void main(String[] args) {

        abstraction outer = new abstraction();

        B obj = outer.new B();

        obj.Show();
    }
}