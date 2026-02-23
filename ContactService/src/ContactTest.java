import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    // ---------- Helpers ----------
    private Contact makeValidContact() {
        return new Contact("123", "Max", "Winfield", "2015550123", "123 Main Street");
    }

    private String repeat(char ch, int count) {
        return String.valueOf(ch).repeat(count);
    }

    // ---------- Valid creation ----------
    @Test
    void testValidContactCreation() {
        Contact c = makeValidContact();
        assertEquals("123", c.getContactId());
        assertEquals("Max", c.getFirstName());
        assertEquals("Winfield", c.getLastName());
        assertEquals("2015550123", c.getPhone());
        assertEquals("123 Main Street", c.getAddress());
    }

    // ---------- contactId validations (required, <=10, not null, not updatable) ----------
    @Test
    void testInvalidContactId_Null() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Max", "Winfield", "2015550123", "123 Main Street"));
    }

    @Test
    void testInvalidContactId_TooLong() {
        String tooLongId = repeat('A', 11);
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(tooLongId, "Max", "Winfield", "2015550123", "123 Main Street"));
    }

    // ---------- firstName validations (required, <=10, not null) ----------
    @Test
    void testInvalidFirstName_Null() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", null, "Winfield", "2015550123", "123 Main Street"));
    }

    @Test
    void testInvalidFirstName_TooLong() {
        String tooLongFirst = repeat('B', 11);
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", tooLongFirst, "Winfield", "2015550123", "123 Main Street"));
    }

    // ---------- lastName validations (required, <=10, not null) ----------
    @Test
    void testInvalidLastName_Null() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", null, "2015550123", "123 Main Street"));
    }

    @Test
    void testInvalidLastName_TooLong() {
        String tooLongLast = repeat('C', 11);
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", tooLongLast, "2015550123", "123 Main Street"));
    }

    // ---------- phone validations (required, exactly 10 digits, not null) ----------
    @Test
    void testInvalidPhone_Null() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", "Winfield", null, "123 Main Street"));
    }

    @Test
    void testInvalidPhone_TooShort() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", "Winfield", "123456789", "123 Main Street")); // 9 digits
    }

    @Test
    void testInvalidPhone_TooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", "Winfield", "12345678901", "123 Main Street")); // 11 digits
    }

    @Test
    void testInvalidPhone_NonDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", "Winfield", "20155A0123", "123 Main Street"));
    }

    // ---------- address validations (required, <=30, not null) ----------
    @Test
    void testInvalidAddress_Null() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", "Winfield", "2015550123", null));
    }

    @Test
    void testInvalidAddress_TooLong() {
        String tooLongAddress = repeat('D', 31);
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "Max", "Winfield", "2015550123", tooLongAddress));
    }

    // ---------- Setter validations (boosts coverage + matches real usage) ----------
    @Test
    void testSetFirstName_Invalid_Null() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
    }

    @Test
    void testSetFirstName_Invalid_TooLong() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(repeat('E', 11)));
    }

    @Test
    void testSetLastName_Invalid_Null() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
    }

    @Test
    void testSetLastName_Invalid_TooLong() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(repeat('F', 11)));
    }

    @Test
    void testSetPhone_Invalid_Null() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
    }

    @Test
    void testSetPhone_Invalid_Format() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345678901"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345x7890"));
    }

    @Test
    void testSetAddress_Invalid_Null() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
    }

    @Test
    void testSetAddress_Invalid_TooLong() {
        Contact c = makeValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(repeat('G', 31)));
    }
}
