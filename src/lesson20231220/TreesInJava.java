package lesson20231220;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreesInJava {

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("key 1", "value 1");
        map.put("key 2", "value 2");
        map.put("key 3", "value 3");
        System.out.println(map.get("key 3"));

        map.put("key 3", "value 4");
        System.out.println(map.get("key 3"));
        System.out.println(map.size());

        Set<String> set = new TreeSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("C");
        System.out.println(set.size());
    }

}
