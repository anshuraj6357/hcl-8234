package module1;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the week day name");
        String weekday = sc.nextLine().toLowerCase();

        String s= switch (weekday) {

            case "monday", "tuesday", "wednesday",
                 "thursday", "friday":
                    yield "This is the Working Day";

            case "saturday", "sunday" :
                    yield "This is the Weekend Day";

            default:
                   yield "Invalid Day";
        };
        System.out.println(s);

        sc.close();
    }
}