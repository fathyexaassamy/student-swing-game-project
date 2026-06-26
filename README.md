# student-swing-game-project
Mini Project Pemograman Dasar Fathy Exa Assamy 5026251081 Kelas A
# Simple Tic-Tac-Toe Game dengan Java Swing, Login, dan Statistik

## Informasi Mahasiswa

**Nama:** Fathy Exa Assamy  
**NRP:** 5026251081  
**Kelas:** A

---

## Deskripsi Project

Project ini merupakan permainan sederhana Tic-Tac-Toe yang dibuat menggunakan Java Swing. Aplikasi ini dilengkapi dengan sistem login yang terhubung ke database PostgreSQL, sehingga setiap pemain dapat bermain menggunakan akun masing-masing. Hasil permainan akan otomatis disimpan ke database, meliputi jumlah kemenangan, kekalahan, seri, serta skor pemain.

---

## Fitur

- Login menggunakan database PostgreSQL
- Bermain Tic-Tac-Toe dengan antarmuka Java Swing
- Pencatatan kemenangan (Wins)
- Pencatatan kekalahan (Losses)
- Pencatatan hasil seri (Draws)
- Perhitungan skor secara otomatis
- Menampilkan statistik pemain
- Menampilkan Top 5 pemain berdasarkan skor
- Logout

---

## Teknologi yang Digunakan

- Java
- Java Swing
- PostgreSQL
- JDBC PostgreSQL Driver
- Visual Studio Code

---

## Database

Database yang digunakan adalah **PostgreSQL**.

Tabel utama:

**players**

| Kolom | Keterangan |
|--------|------------|
| id | ID pemain |
| username | Username pemain |
| password | Password pemain |
| wins | Jumlah kemenangan |
| losses | Jumlah kekalahan |
| draws | Jumlah hasil seri |
| score | Total skor |

Script database dapat ditemukan pada:

```
Database/schema.sql
```

---

## Struktur Project

```
student-swing-game-project
│
├── Database
│   └── schema.sql
│
├── Screenshots
│   ├── login.png
│   ├── mainmenu.png
│   ├── gameplay.png
│   ├── statistics.png
│   └── top5.png
│
├── lib
│   └── postgresql-42.7.10.jar
│
├── src
│   ├── Main.java
│   ├── DatabaseManager.java
│   ├── Player.java
│   ├── PlayerService.java
│   ├── GameLogic.java
│   ├── LoginFrame.java
│   ├── MainMenuFrame.java
│   ├── GameFrame.java
│   ├── StatisticsFrame.java
│   └── TopScorersFrame.java
│
└── README.md
```

---

## Cara Menjalankan Program

1. Buat database PostgreSQL.
2. Jalankan file `Database/schema.sql`.
3. Buka project menggunakan Visual Studio Code atau IDE Java lainnya.
4. Tambahkan PostgreSQL JDBC Driver (`postgresql-42.7.10.jar`).
5. Atur konfigurasi database pada `DatabaseManager.java`.
6. Compile seluruh file Java.
7. Jalankan `Main.java`.

---

## Penjelasan Class

### Main.java

Class utama yang menjalankan aplikasi dan menampilkan halaman login.

### DatabaseManager.java

Mengelola koneksi antara aplikasi Java dengan database PostgreSQL.

### Player.java

Merepresentasikan objek pemain yang berisi informasi akun dan statistik permainan.

### PlayerService.java

Mengelola proses login, mengambil data pemain, serta memperbarui statistik pemain ke database.

### GameLogic.java

Berisi seluruh logika permainan Tic-Tac-Toe, seperti pergantian giliran, validasi langkah, pengecekan pemenang, dan pengecekan hasil seri.

### LoginFrame.java

Menampilkan halaman login dan melakukan autentikasi pengguna.

### MainMenuFrame.java

Menampilkan menu utama setelah pemain berhasil login.

### GameFrame.java

Menampilkan papan permainan Tic-Tac-Toe dan mengatur jalannya permainan.

### StatisticsFrame.java

Menampilkan statistik pemain yang sedang login.

### TopScorersFrame.java

Menampilkan lima pemain dengan skor tertinggi.

---

## Screenshot

### Halaman Login



### Menu Utama

![Main Menu](Screenshots/mainmenu.png)

### Permainan Tic-Tac-Toe

![Gameplay](Screenshots/gameplay.png)

### Statistik Pemain

![Statistics](Screenshots/statistics.png)

### Top 5 Scorer

![Top 5](Screenshots/top5.png)

---

## Pengembangan Selanjutnya

- Menambahkan fitur registrasi akun.
- Menambahkan mode bermain melawan komputer (AI).
- Menambahkan mode multiplayer online.
- Menambahkan efek suara dan animasi.
- Memperbaiki tampilan antarmuka agar lebih menarik.
- Menyimpan riwayat pertandingan.

---

## Penulis

**Fathy Exa Assamy**  
NRP 5026251081  
Departemen Sistem Informasi  
Institut Teknologi Sepuluh Nopember (ITS)

---

## Link Video Demonstrasi

YouTube: https://youtu.be/u1OvC88GDjI
