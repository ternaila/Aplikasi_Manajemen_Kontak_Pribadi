public class Contact extends Person implements Identifiable {
    private int id;
    private String nomor;
    private String email;
    private String alamat;

    // Constructor untuk insert data baru
    public Contact(String nama, String nomor, String email, String alamat) {
        super(nama); // Memanggil constructor Person
        this.nomor = nomor;
        this.email = email;
        this.alamat = alamat;
    }

    // Constructor untuk data dari database
    public Contact(int id, String nama, String nomor, String email, String alamat) {
        super(nama);
        this.id = id;
        this.nomor = nomor;
        this.email = email;
        this.alamat = alamat;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDisplayName() {
        return nama;
    }

    // Method ini yang dicari oleh Menu.java (Menghilangkan Error Merah)
    @Override
    public String getInfo() {
        return id + " | " + nama + " | " + nomor + " | " + email;
    }

    // Getter tambahan
    public String getNama() { return nama; }
    public String getNomor() { return nomor; }
    public String getEmail() { return email; }
    public String getAlamat() { return alamat; }
}


