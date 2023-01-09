import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    public static final  String goodPhoneNumber = "89281112233";
    public static final  String goodName = "89281112233";

    public static final String badPhoneNumber = "9281112233";
    public static final String badName= null;
    public PhoneBook phoneBook;

    @BeforeEach
    public void init(){
        phoneBook = new PhoneBook();
    }

    @Test
    public void successAdd() {
        Assertions.assertTrue(phoneBook.add(goodName, goodPhoneNumber));
    }

    @Test
    public void notSuccessAdd() {
        Assertions.assertFalse(phoneBook.add(badName, badPhoneNumber));
    }
}
