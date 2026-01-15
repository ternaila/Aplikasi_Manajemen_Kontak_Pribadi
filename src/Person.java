public abstract class Person {
    protected String nama;

    public Person(String nama) {
        this.nama = nama;
    }

    // Abstract method yang wajib diisi oleh Contact
    public abstract String getInfo();
}

