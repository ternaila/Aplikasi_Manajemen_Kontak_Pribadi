package Service;

import java.util.ArrayList;
import Model.Contact;

public class ContactManager {
    // Menyimpan daftar kontak
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Tambah kontak
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Ambil semua kontak
    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }

    // Update kontak
    public void updateContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
        }
    }

    // Hapus kontak
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }
}
