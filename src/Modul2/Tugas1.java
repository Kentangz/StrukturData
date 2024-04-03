package Modul2;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar Kontak:");
            for (Contact contact : contacts) {
                System.out.println("Nama : " + contact.getName() + " <-> "+ "Nomer : " + contact.getPhoneNumber());
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan:");
                System.out.println("Nama : " + contact.getName() + "\n"+"Nomor : " + contact.getPhoneNumber());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kontak dengan nama '" + name + "' tidak ditemukan.");
        }
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan nama kontak: ");
                        String name = scanner.nextLine();
                        System.out.print("Masukkan nomor telepon: ");
                        String phoneNumber = scanner.nextLine();
                        Contact contact = new Contact(name, phoneNumber);
                        contactManager.addContact(contact);
                        System.out.println("Kontak berhasil ditambahkan.");
                        break;
                    case 2:
                        contactManager.displayContacts();
                        break;
                    case 3:
                        System.out.print("Masukkan nama kontak yang ingin dicari: ");
                        String searchName = scanner.nextLine();
                        contactManager.searchContact(searchName);
                        break;
                    case 4:
                        System.out.println("Terima kasih!");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, 3, atau 4.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan. Pastikan Anda memasukkan input yang sesuai.");
                scanner.nextLine(); // Membersihkan buffer
            }
        }
    }
}
