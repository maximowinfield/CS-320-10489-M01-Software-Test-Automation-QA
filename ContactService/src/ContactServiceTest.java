import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private Contact makeValidContact(String id) {
        return new Contact(id, "Max", "Winfield", "2015550123", "123 Main Street");
    }

    // ---------- Add ----------
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact c = makeValidContact("1");
        service.addContact(c);
        assertNotNull(service.getContact("1"));
    }

    @Test
    void testAddContact_NullContact_Throws() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testDuplicateContactId() {
        ContactService service = new ContactService();
        Contact c1 = makeValidContact("1");
        Contact c2 = new Contact("1", "Leo", "Marulanda", "9735550123", "456 Oak Street");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    // ---------- Delete ----------
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact(makeValidContact("1"));

        service.deleteContact("1");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("1"));
    }

    @Test
    void testDeleteContact_NonExistentId_Throws() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("missing"));
    }

    // ---------- Update (happy path) ----------
    @Test
    void testUpdateContact_AllFields() {
        ContactService service = new ContactService();
        service.addContact(makeValidContact("1"));

        service.updateFirstName("1", "Alex");
        service.updateLastName("1", "Smith");
        service.updatePhone("1", "9735550123");
        service.updateAddress("1", "456 Oak Road");

        Contact updated = service.getContact("1");
        assertEquals("Alex", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("9735550123", updated.getPhone());
        assertEquals("456 Oak Road", updated.getAddress());
    }

    // ---------- Update (error paths) ----------
    @Test
    void testUpdateFirstName_NonExistentId_Throws() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("missing", "Alex"));
    }

    @Test
    void testUpdatePhone_InvalidValue_Throws() {
        ContactService service = new ContactService();
        service.addContact(makeValidContact("1"));

        // Contact.setPhone enforces \\d{10}
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "12345678901"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "12345x7890"));
    }

    @Test
    void testUpdateAddress_InvalidValue_Throws() {
        ContactService service = new ContactService();
        service.addContact(makeValidContact("1"));

        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("1", "A".repeat(31)));
    }
}
