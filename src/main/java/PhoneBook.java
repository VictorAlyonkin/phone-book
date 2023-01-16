import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    private Map<String, String> phoneNumbers;

    public PhoneBook() {
        this.phoneNumbers = new HashMap<>();
    }

    public boolean add(String number, String name) {
        if (number != null &&
                number.length() == 11 &&
                name != null) {
            phoneNumbers.put(number, name);
            return true;
        }
        return false;
    }

    public String findByNumber(String number) {
        String name = phoneNumbers.get(number);
        if (name != null)
            return name;
        return null;
    }

    public String findByName(String name) {
        Map<String, String> phoneNumbers = this.phoneNumbers
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        return phoneNumbers.get(name);
    }

    public SortedSet<String> printAllNames() {
        SortedSet<String> values = new TreeSet<>(phoneNumbers.values());
        if (values.isEmpty())
            return null;
        values.forEach(System.out::println);
        return values;
    }
}
