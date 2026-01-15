import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private ContactService service = new ContactService();
    private Scanner sc = new Scanner(System.in);

    public void tampilMenu() {
        while (true) {
            try { // Exception Handling (Materi 9)
                System.out.println("\n--- Contact Manager (PBO App) ---");
                System.out.println("1. Tambah Kontak");
                System.out.println("2. Lihat Semua Kontak");
                System.out.println("3. Hapus Kontak");
                System.out.println("0. Keluar");
                System.out.print("Pilih: ");

                int pilih = Integer.parseInt(sc.nextLine()); // Mencegah InputMismatch

                if (pilih == 0) break;

                switch (pilih) {
                    case 1:
                        tambahData();
                        break;
                    case 2:
                        lihatData();
                        break;
                    case 3:
                        hapusData();
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus angka!");
            } catch (SQLException e) {
                System.out.println("Error Database: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private void tambahData() throws SQLException {
        System.out.print("Nama: "); String nama = sc.nextLine();
        System.out.print("Nomor: "); String nomor = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Alamat: "); String alamat = sc.nextLine();
        service.tambahKontak(nama, nomor, email, alamat);
    }

    private void lihatData() throws SQLException {
        // Polimorfisme (Materi 5): Memperlakukan Contact sebagai Person/Identifiable
        for (Contact c : service.tampilSemua()) {
            System.out.println(c.getInfo());
        }
    }

    private void hapusData() throws SQLException {
        System.out.print("ID yang dihapus: ");
        int id = Integer.parseInt(sc.nextLine());
        service.hapusKontak(id);
        System.out.println("Kontak berhasil dihapus.");
    }
}
