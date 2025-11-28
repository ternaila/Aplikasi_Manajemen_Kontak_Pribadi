import Service.ContactManager;
import Model.Contact;

public class Main {
    public static void main(String[] args) {

        ContactManager manager = new ContactManager();

        // Contoh data awal
        manager.addContact(new Contact("Tata", "08xxxx", "tata@gmail.com"));
        manager.addContact(new Contact("Siti", "08xxxx", "siti@gmail.com"));

        System.out.println("=== Daftar Kontak ===");
        for (Contact c : manager.getAllContacts()) {
            System.out.println(c);
        }
    }
}
