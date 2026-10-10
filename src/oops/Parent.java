package hcl_day2;

class Parent {

    void show() {
        System.out.println("Parent show method");
    }

    void display() {
        System.out.println("Parent display method");
    }
}


class Child extends Parent {


    @Override
    void display() {
        System.out.println("Child display method");
    }


    public static void main(String[] args) {

        Child obj = new Child();

        obj.show();
        obj.display();
    }
}