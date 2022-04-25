package Contact_Service_Project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ContactTest {
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
	 void contactTest() {
		Contact contact = new Contact();
		assertAll("constructor",
				() -> assertNotNull(contact.getContactId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	 	}
	@Test
	void contactIdConstructorTest() {
	Contact contact = new Contact(contactId);
	assertAll("constructor one",
			() -> assertEquals(contactId, contact.getContactId()),
			() -> assertNotNull(contact.getFirstName()),
			() -> assertNotNull(contact.getLastName()),
			() -> assertNotNull(contact.getPhoneNumber()),
			() -> assertNotNull(contact.getAddress()));
	}
	@Test
	void contactIdAndFirstNameConstructorTest() {
		Contact contact = new Contact(contactId, testFistName);
		assertAll("constructor two",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(testFistName, contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	@Test
	void contactIdAndFullNameConstructorTest() {
		Contact contact = new Contact(contactId, testFistName, testLastName);
		assertAll("constructor three",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(testFistName, contact.getFirstName()),
				() -> assertEquals(testLastName, contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	@Test
	void contactIdFullNamePhoneNumberConstructorTest() {
		Contact contact =
				new Contact(contactId, testFistName, testLastName, testPhoneNumber);
		assertAll("constructor four",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(testFistName, contact.getFirstName()),
				() -> assertEquals(testLastName, contact.getLastName()),
				() -> assertEquals(testPhoneNumber, contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	@Test
	void allTheProperThingsConstructorTest() {
		Contact contact = new Contact(contactId, testFistName, testLastName,testPhoneNumber, testAddress);
		assertAll("constructor all",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(testFistName, contact.getFirstName()),
				() -> assertEquals(testLastName, contact.getLastName()),
				() -> assertEquals(testPhoneNumber, contact.getPhoneNumber()),
				() -> assertEquals(testAddress, contact.getAddress()));
	}
	@Test
	void updatetestFistName() {
		Contact contact = new Contact();
		contact.updateFirstName(testFistName);
		assertAll(
				"first name",
				() -> assertEquals(testFistName, contact.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.updateFirstName(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> contact.updateFirstName(tooLongFirstName)));
		 	}
		 @Test
		 void updatetestLastName() {
			 Contact contact = new Contact();
			 contact.updateLastName(testLastName);
			 assertAll("last name",
					 () -> assertEquals(testLastName, contact.getLastName()),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updateLastName(null)),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updateLastName(tooLongFirstName)));
		 }
		 @Test
		 void updatetestPhoneNumber() {
			 Contact contact = new Contact();
			 contact.updatePhoneNumber(testPhoneNumber);
			 assertAll("phone number",
					 () -> assertEquals(testPhoneNumber, contact.getPhoneNumber()),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updatePhoneNumber(null)),
					 () -> assertThrows(IllegalArgumentException.class,() -> contact.updatePhoneNumber(tooLongPhoneNumber)),
					 () -> assertThrows(IllegalArgumentException.class,() -> contact.updatePhoneNumber(tooShortPhoneNumber)),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updatePhoneNumber(contactId)));
		 }
		 @Test
		 void updatetestAddress() {
			 Contact contact = new Contact();
			 contact.updateAddress(testAddress);
			 assertAll("phone number",
					 () -> assertEquals(testAddress, contact.getAddress()),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updateAddress(null)),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updateAddress(tooLongAddress)));
		 }
		 @Test
		 void updateContactIdTest() {
			 Contact contact = new Contact();
			 contact.updateContactId(contactId);
			 assertAll("contact ID",
					 () -> assertEquals(contactId, contact.getContactId()),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updateContactId(null)),
					 () -> assertThrows(IllegalArgumentException.class,
							 () -> contact.updateContactId(tooLongContactId)));
		 }
}
