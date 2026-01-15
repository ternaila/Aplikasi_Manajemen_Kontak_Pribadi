import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

// Mewarisi JFrame (Konsep Inheritance/Pewarisan di GUI)
public class ContactGUI extends JFrame {
    private ContactService service;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtNama, txtNomor, txtEmail, txtAlamat;

    public ContactGUI() {
        service = new ContactService();
        initComponents();
        loadData(); // Load data saat aplikasi dibuka
    }

    private void initComponents() {
        // --- Setting Window Utama ---
        setTitle("Aplikasi Kontak Mahasiswa (PBO Project)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Posisi di tengah layar
        setLayout(new BorderLayout());

        // --- PANEL INPUT (Formulir di Atas) ---
        JPanel panelInput = new JPanel(new GridLayout(5, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelInput.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Nomor HP:"));
        txtNomor = new JTextField();
        panelInput.add(txtNomor);

        panelInput.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panelInput.add(txtEmail);

        panelInput.add(new JLabel("Alamat:"));
        txtAlamat = new JTextField();
        panelInput.add(txtAlamat);

        JButton btnSimpan = new JButton("Simpan Kontak");
        panelInput.add(btnSimpan);

        JButton btnHapus = new JButton("Hapus Terpilih");
        panelInput.add(btnHapus);

        add(panelInput, BorderLayout.NORTH);

        // --- TABEL DATA (Di Tengah) ---
        // Membuat Model Tabel (Kolom)
        String[] columnNames = {"ID", "Nama", "Nomor", "Email", "Alamat"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table); // Agar bisa discroll
        add(scrollPane, BorderLayout.CENTER);

        // --- ACTION LISTENER (Logika Tombol) ---

        // Logika Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });

        // Logika Tombol Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusData();
            }
        });
    }

    private void loadData() {
        // Menghapus data lama di tabel GUI
        tableModel.setRowCount(0);
        try {
            // Mengambil data dari Database via Service
            List<Contact> contacts = service.tampilSemua();
            for (Contact c : contacts) {
                // Memasukkan data ke baris tabel
                Object[] rowData = {
                        c.getId(),
                        c.getNama(),
                        c.getNomor(),
                        c.getEmail(),
                        c.getAlamat()
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }
    }

    private void simpanData() {
        String nama = txtNama.getText();
        String nomor = txtNomor.getText();
        String email = txtEmail.getText();
        String alamat = txtAlamat.getText();

        try {
            // Memanggil Service untuk insert ke Database
            service.tambahKontak(nama, nomor, email, alamat);
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
            clearForm();
            loadData(); // Refresh tabel
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal simpan: " + e.getMessage());
        }
    }

    private void hapusData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang mau dihapus dulu!");
            return;
        }

        // Ambil ID dari kolom ke-0 (ID) pada baris yang dipilih
        int id = (int) tableModel.getValueAt(selectedRow, 0);

        // Konfirmasi Hapus
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin hapus ID " + id + "?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                service.hapusKontak(id);
                loadData(); // Refresh tabel
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal hapus: " + e.getMessage());
            }
        }
    }

    private void clearForm() {
        txtNama.setText("");
        txtNomor.setText("");
        txtEmail.setText("");
        txtAlamat.setText("");
    }
}


