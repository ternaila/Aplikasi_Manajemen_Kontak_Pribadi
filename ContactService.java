package service;

import dao.ContactDAO;
import model.Contact;

import java.sql.SQLException;
import java.util.List;

public class ContactService {
    private ContactDAO dao = new ContactDAO();

    public void tambahKontak(String nama, String nomor, String email, String alamat) throws SQLException {
        if (nama.isEmpty() || nomor.isEmpty()) {
            System.out.println("Nama & Nomor wajib diisi!");
            return;
        }
        dao.insertContact(new Contact(nama, nomor, email, alamat));
    }

    public List<Contact> tampilSemua() throws SQLException {
        return dao.getAllContacts();
    }

    public void hapusKontak(int id) throws SQLException {
        dao.deleteContact(id);
    }
}
