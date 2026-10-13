package module1;

import java.util.ArrayList;

public class wildcard {
    class imp{
        static void display(ArrayList<?> list){
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
            System.out.println("display");
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        ArrayList<String> list2=new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        System.out.println(list2);

    }
}
