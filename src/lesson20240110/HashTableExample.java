package lesson20240110;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExample {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>(16, 0.75f);
        map.put("A", 123);
        map.put("B", 123);
        map.put("C", 123);
        map.put("C", 321); // will replace 123

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");

        // HashTable:
        // equals() must be consistent with hashCode()
        // o1.equals(o2) == true ------> o1.hashCode() == o2.hashCode()

        // Tree:
        // equals() must be consistent with compareTo()
        // o1.equals(o2) == true <------> o1.compareTo(o2) == 0
    }

}
