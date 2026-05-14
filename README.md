

# 🗺️ EsemkaTourism (Namatara) - LKS DKI Jakarta 2025
> **Mobile Android Application for Tourism & Cultural Exploration**

[cite_start]**EsemkaTourism** adalah aplikasi perjalanan yang dirancang untuk para penjelajah dan penggemar budaya[cite: 255]. [cite_start]Aplikasi ini berfungsi sebagai panduan digital untuk menemukan keindahan berbagai destinasi, mulai dari lanskap alam yang memukau hingga festival budaya yang semarak[cite: 256, 257].

---

## 🚀 Fitur Utama

### 1. 🔐 Manajemen Akses (Auth)
Sistem keamanan untuk memverifikasi identitas pengguna sebelum mengeksplorasi destinasi.
* [cite_start]**Login Screen:** Verifikasi menggunakan Username dan Password yang tervalidasi melalui Backend API[cite: 283, 284].
* [cite_start]**Sign-Up Screen:** Pendaftaran akun baru dengan validasi kecocokan kata sandi dan data diri pengguna[cite: 298, 300].

### 2. 🏠 Eksplorasi Destinasi (Main Screen)
[cite_start]Pusat navigasi aplikasi menggunakan `BottomNavigationView`[cite: 318].
* [cite_start]**Home Screen:** Menampilkan daftar kategori pariwisata (seperti Acara & Festival, Homestay) dalam tata letak dua kolom yang dapat digulir[cite: 331, 332].
* [cite_start]**Tourism Screen:** Fitur pencarian destinasi berdasarkan kata kunci judul dengan informasi jam buka dan deskripsi singkat[cite: 370, 372].

### 3. 👤 Profil & Personalisasi
Ruang khusus bagi pengguna untuk mengelola pengalaman mereka.
* [cite_start]**My Profile Screen:** Menampilkan informasi profil serta daftar destinasi yang telah diberikan rating (`MyRatings`) atau disimpan (`MyBookmarks`)[cite: 351, 352].
* [cite_start]**Tourism Detail:** Informasi mendalam mengenai destinasi, termasuk lokasi, harga tiket, rating interaktif, dan fitur bookmark[cite: 388, 390].

---

## 🛠️ Persyaratan Teknis (Technical Requirements)

Sebagai pengembang, aplikasi harus memenuhi kriteria berikut:
* [cite_start]**Format Proyek:** Nama proyek harus menggunakan format `Mobile_[XX]` (XX adalah nomor PC)[cite: 276].
* [cite_start]**Integrasi API:** Aplikasi terhubung dengan Web API yang disediakan menggunakan URL localhost `http://10.0.2.2:5000`[cite: 259, 268].
* [cite_start]**UI Precision:** Antarmuka harus mengikuti desain komponen secara presisi (labels, buttons, images) tanpa ada yang terlewat[cite: 276].
* [cite_start]**Validasi & Error:** Wajib mengimplementasikan validasi pada setiap proses input dan menampilkan pesan error yang informatif[cite: 276].

---

## 💻 Cara Instalasi & Konfigurasi

1. **Persiapan Backend:**
   * [cite_start]Jalankan file `EsemkaTourism.exe` yang terdapat dalam folder "Web API"[cite: 266, 268].
   * [cite_start]Pastikan dokumentasi Swagger dapat diakses untuk referensi endpoint[cite: 273].
2. **Konfigurasi Android:**
   * [cite_start]Pastikan URL API diatur ke `http://10.0.2.2:5000` untuk emulator[cite: 268].
   * [cite_start]URL Gambar diatur ke `http://10.0.2.2:5000/images/`[cite: 268].
3. **Build Project:**
   * Lakukan *Sync Project with Gradle Files* dan jalankan pada perangkat Android atau Emulator.

---

## 📐 Tanggung Jawab Pengembang
* [cite_start]**Manajemen Waktu:** Mengelola waktu pengerjaan dengan bijak sesuai batas waktu lomba[cite: 276].
* [cite_start]**Stabilitas:** Memastikan aplikasi berjalan lancar tanpa *crash*[cite: 276].
* [cite_start]**Fungsionalitas:** Mengutamakan fitur fungsional dibandingkan estetika desain tambahan[cite: 276].

---

**Dikembangkan untuk:** LKS Provinsi DKI Jakarta 2025  
[cite_start]**Bidang Lomba:** IT Software Solutions for Business (Mobile Android) [cite: 252, 253]  
**Status:** Competitor Submission
