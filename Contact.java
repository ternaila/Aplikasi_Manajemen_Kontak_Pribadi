package model;

public class Contact {
    private int id;
    private String nama;
    private String nomor;
    private String email;
    private String alamat;

    public Contact(String nama, String nomor, String email, String alamat) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
        this.alamat = alamat;
    }

    public Contact(int id, String nama, String nomor, String email, String alamat) {
        this.id = id;
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
        this.alamat = alamat;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getNomor() { return nomor; }
    public String getEmail() { return email; }
    public String getAlamat() { return alamat; }
}
