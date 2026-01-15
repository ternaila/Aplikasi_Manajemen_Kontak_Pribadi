import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Menjalankan GUI di Thread yang aman
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Membuat objek GUI dan menampilkannya
                new ContactGUI().setVisible(true);
            }
        });
    }
}



