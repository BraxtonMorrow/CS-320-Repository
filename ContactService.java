//Author Name: Braxton Morrow

//Date:3-20-2022

//Course ID:CS 320

//Description: Unit tests to verify that this is able to add, update, and delete contact objects within the application.
package Contact_Service_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class ContactService {
	private String uniqueId;
	private List<Contact> contactList = new ArrayList<>();{
		uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	public void newContact() {
		Contact contact = new Contact(newUniqueId());
		contactList.add(contact);
	}
	public void newContact(String firstname) {
		Contact contact = new Contact(newUniqueId(), firstname);
		contactList.add(contact);
	}
	public void newContact(String firstname, String lastname) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname);
		contactList.add(contact);
	}
	public void newContact(String firstname, String lastname,String phonenumber) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber);
		contactList.add(contact);
	}
	public void newContact(String firstname, String lastname, String phonenumber,String address) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
		contactList.add(contact);
	}
	public void deleteContact(String id) throws Exception {
		contactList.remove(searchForContact(id));
	}
	public void updateFirstName(String id, String firstName) throws Exception {
		searchForContact(id).updateFirstName(firstName);
	}
	public void updateLastName(String id, String lastName) throws Exception {
		searchForContact(id).updateLastName(lastName);
	}
	public void updatePhoneNumber(String id, String phoneNumber)
			throws Exception {
		searchForContact(id).updatePhoneNumber(phoneNumber);
	}
	public void updateAddress(String id, String address) throws Exception {
		searchForContact(id).updateAddress(address);
	}
	protected List<Contact> getContactList() { return contactList; }
	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	private Contact searchForContact(String id) throws Exception {
		int i = 0;
		while (i < contactList.size()) {
			if (id.equals(contactList.get(i).getContactId())) {
				return contactList.get(i);
			}
			i++;
		}
		throw new Exception("Cannot compute, cannot compute...");
	}
}