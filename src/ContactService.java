import java.sql.SQLException;
import java.util.List;

public class ContactService {
    // Relasi Antar Class: Komposisi/Agregasi (Materi 6)
    private ContactDAO dao = new ContactDAO();

    public void tambahKontak(String nama, String nomor, String email, String alamat) throws SQLException {
        if (nama.isEmpty() || nomor.isEmpty()) {
            System.out.println("Nama & Nomor wajib diisi!");
            return;
        }
        Contact newContact = new Contact(nama, nomor, email, alamat);
        dao.insertContact(newContact);
    }

    public List<Contact> tampilSemua() throws SQLException {
        return dao.getAllContacts();
    }

    public void hapusKontak(int id) throws SQLException {
        dao.deleteContact(id);
    }
}


