package oops;

public class A {

     A() {
        System.out.println("This is a constructor");
    }

    static class Demo {

        public static void main(String[] args) {

            A obj = new A();
        }
    }
}