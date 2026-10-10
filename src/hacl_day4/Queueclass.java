package hacl_day4;

import java.util.LinkedList;
import java.util.Queue;

public class Queueclass {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.offer(4);
        System.out.println(q);
    }
}
