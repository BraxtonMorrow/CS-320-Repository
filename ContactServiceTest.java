package Contact_Service_Project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ContactServiceTest {
	protected String contactId, testFistName, testLastName, testPhoneNumber,testAddress;
	protected String tooLongContactId, tooLongFirstName, tooLongLastName,tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;
	@BeforeEach
	void setUp() {
		contactId = "123ASDF123";
		testFistName = "Jenny";
		testLastName = "Smith";
		testPhoneNumber = "5098675309";
		testAddress = "1323 Cedar Ave WA 99354";
		tooLongContactId = "1234567489101112131415";
		tooLongFirstName = "John Jacob Jingle";
		tooLongLastName = "-heimer Schmidt";
		tooLongPhoneNumber = "911867530999";
		tooShortPhoneNumber = "12345";
		tooLongAddress = "500 South Buena Vista Street, Burbank, CA 91521";
	}
	 @Test
	 void newContactTest() {
		 ContactService service = new ContactService();
		 service.newContact();
		 assertAll("service",
				 () -> assertNotNull(service.getContactList().get(0).getContactId()),
				 () -> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()),
				 () -> assertEquals("INITIAL", service.getContactList().get(0).getLastName()),
				 () -> assertEquals("15098675309", service.getContactList().get(0).getPhoneNumber()),
				 () -> assertEquals("INITIAL", service.getContactList().get(0).getAddress()));
		 		 service.newContact(testFistName);
		 		 assertAll("service",
		 				 () -> assertNotNull(service.getContactList().get(1).getContactId()),
		 				 () -> assertEquals(testFistName,service.getContactList().get(1).getFirstName()),
		 				 () -> assertEquals("INITIAL", service.getContactList().get(1).getLastName()),
		 				 ()	-> assertEquals("15098675309", service.getContactList().get(1).getPhoneNumber()),
		 				 () -> assertEquals("INITIAL", service.getContactList().get(1).getAddress()));
		 		 service.newContact(testFistName, testLastName);
		 		 assertAll("service",
		 				 () -> assertNotNull(service.getContactList().get(2).getContactId()),
		 				 () -> assertEquals(testFistName, service.getContactList().get(2).getFirstName()),
		 				 () -> assertEquals(testLastName, service.getContactList().get(2).getLastName()),
		 				 () -> assertEquals("15098675309", service.getContactList().get(2).getPhoneNumber()),
		 				 () -> assertEquals("INITIAL", service.getContactList().get(2).getAddress()));
		 		 service.newContact(testFistName, testLastName, testPhoneNumber);
		 		 assertAll("service",
		 				 () -> assertNotNull(service.getContactList().get(3).getContactId()),
		 				 () -> assertEquals(testFistName, service.getContactList().get(3).getFirstName()),
		 				 () -> assertEquals(testLastName, service.getContactList().get(3).getLastName()),
		 				 () -> assertEquals(testPhoneNumber, service.getContactList().get(3).getPhoneNumber()),
		 				 () -> assertEquals("INITIAL", service.getContactList().get(3).getAddress()));
		 		 service.newContact(testFistName, testLastName, testPhoneNumber, testAddress);
		 		 assertAll("service",
		 				 () -> assertNotNull(service.getContactList().get(4).getContactId()),
		 				 () -> assertEquals(testFistName, service.getContactList().get(4).getFirstName()),
		 				 () -> assertEquals(testLastName, service.getContactList().get(4).getLastName()),
		 				 () -> assertEquals(testPhoneNumber, service.getContactList().get(4).getPhoneNumber()),
		 				 () -> assertEquals(testAddress, service.getContactList().get(4).getAddress()));
	 }
	 @Test
	 void deleteContactTest() {
		 ContactService service = new ContactService();
		 service.newContact();
		 assertThrows(Exception.class, () -> service.deleteContact(contactId));
		 assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactId()));
	 }
	 @Test
	 void updatetestFistName() throws Exception {
		 ContactService service = new ContactService();
		 service.newContact();
		 service.updateFirstName(service.getContactList().get(0).getContactId(), testFistName);
		 assertEquals(testFistName, service.getContactList().get(0).getFirstName());
		 assertThrows(IllegalArgumentException.class,
				 () -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName));
		 assertThrows(IllegalArgumentException.class,
				 () -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
		 assertThrows(Exception.class,
				 () -> service.updateFirstName(contactId, testFistName));
	 }
	 @Test
	 void updatetestLastName() throws Exception {
		 ContactService service = new ContactService();
		 service.newContact();
		 service.updateLastName(service.getContactList().get(0).getContactId(),testLastName);
		 assertEquals(testLastName, service.getContactList().get(0).getLastName());
		 assertThrows(IllegalArgumentException.class,
				 () -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName));
		 assertThrows(IllegalArgumentException.class,
				 () -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
		 assertThrows(Exception.class,
				 () -> service.updateLastName(contactId, testLastName));
	 }
	 @Test
	 void updatetestPhoneNumber() throws Exception {
		 ContactService service = new ContactService();
		 service.newContact();
		 	service.updatePhoneNumber(service.getContactList().get(0).getContactId(), testPhoneNumber);
		 	assertEquals(testPhoneNumber,
		 			service.getContactList().get(0).getPhoneNumber());
		 	assertThrows(IllegalArgumentException.class,
		 			() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber));
		 	assertThrows(IllegalArgumentException.class,
		 			() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(),tooShortPhoneNumber));
		 	assertThrows(IllegalArgumentException.class,
		 			() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId));
		 	assertThrows(IllegalArgumentException.class,
		 			() -> service.updatePhoneNumber(
		 					service.getContactList().get(0).getContactId(), null));
		 	assertThrows(Exception.class,
		 			() -> service.updatePhoneNumber(contactId, testLastName));
	 }
	 @Test
	 void updatetestAddress() throws Exception {
		 ContactService service = new ContactService();
		 service.newContact();
		 service.updateAddress(service.getContactList().get(0).getContactId(), testAddress);
		 assertEquals(testAddress, service.getContactList().get(0).getAddress());
		 assertThrows(IllegalArgumentException.class,
				 () -> service.updateAddress(service.getContactList().get(0).getContactId(), tooLongAddress));
		 assertThrows(IllegalArgumentException.class,
				 () -> service.updateAddress(service.getContactList().get(0).getContactId(), null));
		 assertThrows(Exception.class,
				 () -> service.updateAddress(contactId, testAddress));
	 }
}
