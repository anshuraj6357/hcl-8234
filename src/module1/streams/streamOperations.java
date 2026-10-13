package module1.streams;

import java.util.*;
import java.util.stream.Collectors;

public class streamOperations {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        // 1. Filter Operation
        System.out.println("1. Filter Operation - Even Numbers:");

        List<Integer> evenNumber = list.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumber);


        // 2. Map Operation
        System.out.println("\n2. Map Operation - Square of Numbers:");

        list.stream()
                .map(x -> x * x)
                .forEach(System.out::println);


        // 3. Sorted Descending Order
        System.out.println("\n3. Sorted Descending Order:");

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        // 4. Sorted Ascending Order
        System.out.println("\n4. Sorted Ascending Order:");

        list.stream()
                .sorted()
                .forEach(System.out::println);


        // 5. Distinct Operation
        System.out.println("\n5. Distinct Operation - Remove Duplicates:");

        list.stream()
                .distinct()
                .forEach(System.out::println);


        // 6. Limit Operation
        System.out.println("\n6. Limit Operation - First 3 Elements:");

        list.stream()
                .limit(3)
                .forEach(System.out::println);


        // 7. Reduce Operation - Sum
        System.out.println("\n7. Reduce Operation - Sum:");

        int sum = list.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);


        // 8. Min Operation
        System.out.println("\n8. Minimum Element:");

        int min = list.stream()
                .min(Integer::compareTo)
                .orElse(-1);

        System.out.println("Minimum = " + min);


        // 9. Max Operation
        System.out.println("\n9. Maximum Element:");

        int max = list.stream()
                .max(Integer::compareTo)
                .orElse(-1);

        System.out.println("Maximum = " + max);


        // 10. FindFirst Operation
        System.out.println("\n10. FindFirst Operation - First Even Number:");

        int first = list.stream()
                .filter(x -> x % 2 == 0)
                .findFirst()
                .orElse(-1);

        System.out.println("First Even Number = " + first);
    }
}