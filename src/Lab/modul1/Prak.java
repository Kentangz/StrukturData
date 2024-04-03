package Lab.modul1;

import java.util.Scanner;

// Enum untuk tipe barang
enum TipeBarang {
    SANDANG,
    PANGAN,
    PAPAN
}

// Class Barang dengan dua generics
class Barang<T, U> {
    private T nama;
    private U harga;
    private TipeBarang tipe;

    // Konstruktor
    public Barang(T nama, U harga, TipeBarang tipe) {
        this.nama = nama;
        this.harga = harga;
        this.tipe = tipe;
    }

    // Getter
    public T getNama() {
        return nama;
    }


    public U getHarga() {
        return harga;
    }


    public TipeBarang getTipe() {
        return tipe;
    }
}

public class Prak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input nama barang (generic 1)
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.nextLine();

        // Input harga barang (generic 2)
        System.out.print("Masukkan harga barang: ");
        int hargaBarang = scanner.nextInt();

        // Input tipe barang (enum)
        System.out.println("Pilih tipe barang:");
        System.out.println("0. Sandang");
        System.out.println("1. Pangan");
        System.out.println("2. Papan");
        System.out.print("Pilihan Anda: ");
        int pilihanTipe = scanner.nextInt();

        // Konversi pilihan menjadi enum TipeBarang
        TipeBarang tipeBarang;
        switch (pilihanTipe) {
            case 0:
                tipeBarang = TipeBarang.SANDANG;
                break;
            case 1:
                tipeBarang = TipeBarang.PANGAN;
                break;
            case 2:
                tipeBarang = TipeBarang.PAPAN;
                break;
            default:
                System.out.println("Pilihan tidak valid, mengatur tipe barang sebagai Sandang secara default.");
                tipeBarang = TipeBarang.SANDANG;
        }

        // Membuat objek Barang
        Barang<String, Integer> barang = new Barang<>(namaBarang, hargaBarang, tipeBarang);

        // Menampilkan informasi barang
        System.out.println("\nInformasi Barang:");
        System.out.println("Nama: " + barang.getNama());
        System.out.println("Harga: " + barang.getHarga());
        System.out.println("Tipe: " + barang.getTipe());
    }
}
