package hacl_day4;

import java.util.HashMap;
import java.util.Map;

public class MapClass {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(3,"a");
        map.put(4,"b");
        map.put(5,"c");
        map.put(6,"d");
        if(map.containsKey(6)){
            map.put(6,"ew");
        }

        map.put(7,"e");
        System.out.println(map);
    }
}
