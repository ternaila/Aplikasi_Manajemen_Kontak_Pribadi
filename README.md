# Aplikasi Manajemen Kontak Pribadi (Contact Management Application)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

Project ini dibuat untuk memenuhi **Tugas Akhir Mata Kuliah Pemrograman Berorientasi Objek (PBO)**.

---

## Deskripsi Project

Aplikasi Manajemen Kontak Pribadi merupakan aplikasi desktop berbasis **Java** yang dirancang untuk membantu pengguna dalam mengelola data kontak secara terstruktur dan efisien. Aplikasi ini memungkinkan pengguna untuk menyimpan, mengubah, menghapus, dan mencari data kontak seperti nama, nomor telepon, email, dan alamat. Seluruh data kontak disimpan secara permanen menggunakan **database MySQL**, sehingga informasi tetap aman dan dapat diakses kembali kapan saja. Pengembangan aplikasi ini menerapkan konsep **Object-Oriented Programming (OOP)** serta integrasi database menggunakan **JDBC**.

---

## Fitur Unggulan

Berikut adalah fitur-fitur utama yang tersedia dalam aplikasi:

### 1. Manajemen Kontak
- CRUD Kontak (Create, Read, Update, Delete).
- Menyimpan informasi kontak seperti:
  - Nama
  - Nomor Telepon
  - Email
  - Alamat
- Menampilkan daftar kontak dalam bentuk tabel.

### 2. Pencarian Kontak
- Pencarian kontak berdasarkan nama atau nomor telepon.
- Memudahkan pengguna menemukan data dengan cepat.

### 3. Integrasi Database
- Penyimpanan data menggunakan **MySQL**.
- Koneksi database menggunakan **JDBC Driver**.
- Data tersimpan secara permanen dan aman.

### 4. Antarmuka Grafis (GUI)
- Menggunakan **Java Swing**.
- Tampilan sederhana, rapi, dan mudah digunakan.
- Navigasi menu yang jelas untuk pengguna.

---

## Tampilan Utama Aplikasi

Aplikasi menyediakan tampilan antarmuka utama yang berisi:
- Form input data kontak
- Tabel daftar kontak
- Tombol Simpan dan Hapus

<img width="978" height="731" alt="image" src="https://github.com/user-attachments/assets/d7af61b0-9247-4da1-a7a3-f4c947068995" />

---

## Cara Instalasi & Menjalankan Aplikasi

### 1. Clone Repository
    gh repo clone ternaila/Aplikasi_Manajemen_Kontak_Pribadi

### 2. Import Database
  - Buka phpMyAdmin / MySQL.
  - Buat database baru dengan nama: contact_db
  - Import file SQL (jika tersedia) atau buat tabel kontak sesuai struktur yang digunakan aplikasi.

### 3. Konfigurasi Database
  - Buka file: src/DatabaseConnection.java 
  - Sesuaikan konfigurasi database:
      - url = "jdbc:mysql://localhost:3306/contact_db";
      - user = "root";
      - password = "";

### 4. Menjalankan Aplikasi
  - Buka project menggunakan IntelliJ IDEA atau NetBeans.
  - Jalankan file:
  - Main.java


## Konsep yang Digunakan
- Object-Oriented Programming (OOP)
- Java Swing (GUI)
- JDBC (Java Database Connectivity)
- MySQL Database
- MVC Sederhana
  

## Kontributor
- Naila Faizah (2400018247)
- Desta Dian Kusumawardani (2400018261)
- Tabina Nur Syahda (2400018283)
- Siti Nur Fatimah Okta. A (2400018297)


Kelas: E
Program Studi: Informatika
Universitas: Universitas Ahmad Dahlan

© 2026 – Dilindungi Hak Cipta
