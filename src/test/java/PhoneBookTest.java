import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    public static final String goodPhoneNumber = "89281112233";
    public static final String goodName = "89281112233";

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
        String number = phoneBook.findByNumber(goodPhoneNumber);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(goodPhoneNumber, number);
    }

    @Test
    public void notSuccessFindByNumber() {
        phoneBook.add(badPhoneNumber, badName);
        String number = phoneBook.findByNumber(badPhoneNumber);
        Assertions.assertNull(number);
    }

    @Test
    public void successFindByName() {
        phoneBook.add(goodPhoneNumber, goodName);
        String number = phoneBook.findByName(goodPhoneNumber);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(goodPhoneNumber, number);
    }

    @Test
    public void notSuccessFindName() {
        phoneBook.add(badPhoneNumber, badName);
        String number = phoneBook.findByName(badPhoneNumber);
        Assertions.assertNull(number);
    }
}
