import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private Map<String, String> phoneNumbers;

    public PhoneBook() {
        this.phoneNumbers = new TreeMap<>();
    }

    public boolean add(String name, String number){
        if (number != null &&
                number.length() == 11 &&
                name != null){
            phoneNumbers.put(name, number);
            return true;
        }
        return false;
    }
}
