package Modul2;

import java.util.Scanner;

class Kontak {
    private String nama;
    private String nomorTelepon;

    public Kontak(String nama, String nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }
}

class ListNode {
    Kontak data;
    ListNode next;

    public ListNode(Kontak data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    ListNode head;

    public LinkedList() {
        head = null;
    }

    public void tambah(Kontak kontak) {
        ListNode newNode = new ListNode(kontak);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void tampilkan() {
        if (head == null) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar Kontak:");
            ListNode temp = head;
            while (temp != null) {
                System.out.println("Nama : " + temp.data.getNama() + " <-> " + "Nomor Telepon : " + temp.data.getNomorTelepon());
                temp = temp.next;
            }
        }
    }

    public void cari(String nama) {
        boolean ditemukan = false;
        ListNode temp = head;
        while (temp != null) {
            if (temp.data.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan:");
                System.out.println("Nama : " + temp.data.getNama() + "\n" +"Nomor Telepon : " + temp.data.getNomorTelepon());
                ditemukan = true;
                break;
            }
            temp = temp.next;
        }
        if (!ditemukan) {
            System.out.println("Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }
}

public class Tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList daftarKontak = new LinkedList();

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Kontak");
                System.out.println("2. Tampilkan Kontak");
                System.out.println("3. Cari Kontak");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu (1/2/3/4): ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama kontak: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan nomor telepon: ");
                        String nomorTelepon = scanner.nextLine();
                        Kontak kontak = new Kontak(nama, nomorTelepon);
                        daftarKontak.tambah(kontak);
                        System.out.println("Kontak berhasil ditambahkan.");
                        break;
                    case 2:
                        daftarKontak.tampilkan();
                        break;
                    case 3:
                        System.out.print("Masukkan nama kontak yang ingin dicari: ");
                        String namaCari = scanner.nextLine();
                        daftarKontak.cari(namaCari);
                        break;
                    case 4:
                        System.out.println("Terima kasih!");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, 3, atau 4.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan. Pastikan Anda memasukkan input yang sesuai.");
                scanner.nextLine();
            }
        }
    }
}
