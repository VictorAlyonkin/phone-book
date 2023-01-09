import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    private Map<String, String> phoneNumbers;

    public PhoneBook() {
        this.phoneNumbers = new TreeMap<>();
    }

    public boolean add(String name, String number) {
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
        Set<Map.Entry<String, String>> entrySet = phoneNumbers.entrySet();
        for (Map.Entry<String, String> pair : entrySet) {
            if (name.equals(pair.getValue())) {
                return pair.getKey();
            }
        }
        return null;
    }
}
