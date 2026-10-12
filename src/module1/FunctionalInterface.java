package module1;

public class FunctionalInterface {
    interface Calculator{
         int calculate(int a,int b);
    }

    public static void main(String[] args) {

        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;
        Calculator div = (a, b) -> a / b;

        System.out.println(add.calculate(10, 20));
        System.out.println(sub.calculate(20, 10));
        System.out.println(mul.calculate(10, 20));
        System.out.println(div.calculate(20, 10));
    }
}
