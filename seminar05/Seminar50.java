import java.util.*;

public class Seminar50 {
    public static void main(String[] args) {
        // Map<Integer, String> passportToName = new HashMap<>();
        // Map<Integer, String> passportToName = new TreeMap<>();
        Map<Integer, String> passportToName = new LinkedHashMap<>();
        passportToName.put(123456, "Иванов");
        passportToName.put(321456, "Васильев");
        passportToName.put(234561, "Петрова");
        passportToName.put(234432, "Иванов");
        passportToName.put(654321, "Петрова");
        passportToName.put(345678, "Иванов");

        System.out.println(passportToName);

        for (Map.Entry<Integer, String> entry : passportToName.entrySet())
            if (entry.getValue().equals("Иванов"))
                System.out.println(entry);
    }
}