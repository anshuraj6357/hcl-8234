package module2.singelton;

public class callmethod {
    public static void main(String[] args) {
        method m1=method.getInstance(2,3);
        method m2=method.getInstance(21,31);
        System.out.println(m1.getA());
        System.out.println(m1.getB());

        System.out.println(m2.getA());
        System.out.println(m2.getB());
    }
}
