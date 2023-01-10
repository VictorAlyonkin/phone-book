import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class PhoneBookTest {
    public static final String goodPhoneNumber = "89281112233";
    public static final String goodName = "Jack";

    public static final String badPhoneNumber = "9281112233";
    public static final String badName = null;
    public PhoneBook phoneBook;

    @BeforeEach
    public void init() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void successAdd() {
        Assertions.assertTrue(phoneBook.add(goodPhoneNumber, goodName));
    }

    @Test
    public void notSuccessAdd() {
        Assertions.assertFalse(phoneBook.add(badPhoneNumber, badName));
    }

    @Test
    public void successFindByNumber() {
        phoneBook.add(goodPhoneNumber, goodName);
        String name = phoneBook.findByNumber(goodPhoneNumber);
        Assertions.assertNotNull(name);
        Assertions.assertEquals(goodName, name);
    }

    @Test
    public void notSuccessFindByNumber() {
        phoneBook.add(badPhoneNumber, badName);
        String name = phoneBook.findByNumber(badPhoneNumber);
        Assertions.assertNull(name);
    }

    @Test
    public void successFindByName() {
        phoneBook.add(goodPhoneNumber, goodName);
        String name = phoneBook.findByName(goodName);
        Assertions.assertNotNull(name);
        Assertions.assertEquals(goodPhoneNumber, name);
    }

    @Test
    public void notSuccessFindName() {
        phoneBook.add(badPhoneNumber, badName);
        String number = phoneBook.findByName(badName);
        Assertions.assertNull(number);
    }

    @Test
    public void successPrintAllNames() {
        SortedSet<String> expectedNames = new TreeSet<>(Collections.singleton(goodName));

        phoneBook.add(goodPhoneNumber, goodName);
        SortedSet<String> actualNames = phoneBook.printAllNames();

        Assertions.assertNotNull(actualNames);
        Assertions.assertEquals(expectedNames, actualNames);
    }

    @Test
    public void notSuccessPrintAllNames() {
        phoneBook.add(badPhoneNumber, badName);
        SortedSet<String> names = phoneBook.printAllNames();
        Assertions.assertNull(names);
    }
}
