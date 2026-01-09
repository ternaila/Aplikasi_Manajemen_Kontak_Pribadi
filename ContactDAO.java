package dao;

import config.DatabaseConnection;
import model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public void insertContact(Contact c) throws SQLException {
        String sql = "INSERT INTO contacts (nama, nomor, email, alamat) VALUES (?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, c.getNama());
        ps.setString(2, c.getNomor());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getAlamat());
        ps.executeUpdate();
    }

    public List<Contact> getAllContacts() throws SQLException {
        List<Contact> list = new ArrayList<>();
        String sql = "SELECT * FROM contacts";
        Connection conn = DatabaseConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            list.add(new Contact(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("nomor"),
                    rs.getString("email"),
                    rs.getString("alamat")
            ));
        }
        return list;
    }

    public void deleteContact(int id) throws SQLException {
        String sql = "DELETE FROM contacts WHERE id=?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
