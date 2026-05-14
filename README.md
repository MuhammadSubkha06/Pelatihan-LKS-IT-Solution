# 🏥 Hospital Management System (HMS)
> **Proyek Lomba Kompetensi Siswa (LKS) Provinsi DKI Jakarta 2024** > **Bidang Lomba: IT Software Solutions for Business (Desktop)**

Sistem Manajemen Rumah Sakit ini dikembangkan menggunakan bahasa pemrograman **C# / VB.Net** dengan **.NET Framework**. Aplikasi ini dirancang untuk mengelola data medis secara digital, mulai dari manajemen klasifikasi penyakit (ICD-11), data dokter dan pasien, hingga pengaturan jadwal pertemuan serta proses pembayaran medis.

---

## 🚀 Fitur Utama

### 1. 🔐 Autentikasi Keamanan (Login)
* [cite_start]**Encrypted Security:** Kata sandi dienkripsi menggunakan algoritma **SHA-512**[cite: 307].
* [cite_start]**Identity Management:** Verifikasi kredensial pengguna dengan fitur *Show Password* untuk akurasi input[cite: 308].

### 2. 📋 Manajemen Data Master
* [cite_start]**Master ICD-11:** Menampilkan klasifikasi penyakit standar internasional beserta deskripsi dan pengecualiannya (*exclusions*)[cite: 328, 329].
* [cite_start]**Master Doctor:** Manajemen informasi dokter lengkap dengan filter kategori spesialis dan pencarian berdasarkan nama[cite: 351, 356, 357].
* [cite_start]**Master Patient:** Pusat data pasien yang mendukung pencarian cepat dan riwayat pembaruan rekam medis[cite: 419, 421].

### 3. 🤝 Manajemen Pertemuan (Meeting)
* [cite_start]**New Meeting:** Penjadwalan pertemuan pasien dengan validasi jadwal agar tidak terjadi bentrok (*overlap*)[cite: 509, 516].
* [cite_start]**Queue System:** Pembuatan nomor antrean otomatis berdasarkan jadwal harian yang diminta[cite: 517].
* [cite_start]**Patient Records:** Pencatatan riwayat medis pasien selama masa pertemuan[cite: 547].
* [cite_start]**Manage Meeting:** Kontrol penuh terhadap jadwal pertemuan, termasuk modifikasi rekam medis dan inisiasi proses pembayaran[cite: 570, 571].

### 4. 💳 Sistem Pembayaran (Payment)
* [cite_start]**Digital Invoicing:** Rekapitulasi biaya layanan dan obat-obatan yang harus dibayar[cite: 639].
* [cite_start]**Credit Card Validation:** Integrasi pembayaran kartu kredit yang divalidasi menggunakan **Luhn Algorithm**[cite: 645].
* [cite_start]**Read-only History:** Transaksi yang telah selesai akan terkunci dalam mode baca saja untuk menjaga integritas data[cite: 640].

---

## 🛠️ Aturan Teknis & Validasi

Berdasarkan pedoman umum kompetisi:
* [cite_start]**Soft Delete:** Penghapusan data tidak menghapus baris dari database, melainkan menggunakan flag pada kolom `deleted_at`[cite: 264, 265].
* **UI/UX Standard:**
    * [cite_start]Setiap form baru harus diposisikan di tengah layar (*center screen*)[cite: 278].
    * [cite_start]Menggunakan *striped white light-gray style* pada komponen DataGridView[cite: 284].
    * [cite_start]Pencarian data menggunakan query `LIKE %search%`[cite: 283].
* [cite_start]**Validation:** Setiap proses input wajib memiliki validasi data untuk memastikan kualitas informasi[cite: 287].

---

## 💻 Cara Instalasi

1. [cite_start]**Project Naming:** Pastikan nama folder proyek mengikuti format `DESKTOP_[XX]` (XX adalah nomor PC)[cite: 256].
2. [cite_start]**Database Setup:** Konfigurasikan database engine lokal tanpa mengubah struktur tabel atau kolom yang tersedia[cite: 262].
3. [cite_start]**Environment:** Pastikan proyek dapat dijalankan di luar lingkungan PC pengembangan asal[cite: 259].

---

**Dikembangkan oleh:** [Nama Peserta]  
**PC Number:** [XX]  
[cite_start]*ITSSB Indonesia Team 2024 - "Programming is thinking, not typing. But of course, why not both?"* [cite: 253, 651]
