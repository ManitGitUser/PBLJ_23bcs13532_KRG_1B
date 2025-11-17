import java.util.*;

public class Sample {
    public static void main (String[] args) {
        Map <Integer, String> mp = new HashMap<>();
        mp.put(1, "Manit Student");
        mp.put(2, "Tapesh Sir");
        for (Integer i : mp.keySet()) {
            System.out.println(i + ":" + mp.get(i));
        }
        for (Map.Entry<Integer, String> i : mp.entrySet()) {
            System.out.println(i.getKey() + " : " + i.getValue());
        }
        System.out.println("Post Script : You were the best teacher of Java I have ever had.");
    }
}