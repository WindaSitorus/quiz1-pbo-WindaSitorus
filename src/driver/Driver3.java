import java.util.ArrayList;
import java.util.Scanner;

class LaundryOrder {
    String nim;
    String nama;
    String asrama;
    String hariJemput;
    String hariAntar;
    String keluhan;
    ArrayList<String> daftarPakaian = new ArrayList<>();
    int totalItem = 0;

    public LaundryOrder(String nim, String nama, String asrama, String keluhan) {
        this.nim = nim;
        this.nama = nama;
        this.asrama = asrama;
        this.keluhan = keluhan;
        setJadwal(asrama);
    }

    private void setJadwal(String asrama) {
        switch (asrama.toLowerCase()) {

            case "max planck":
            case "ada lovelace":
                hariJemput = "Rabu";
                hariAntar = "Kamis";
                break;

            case "simon laplace":
            case "nikola tesla":
                hariJemput = "Selasa";
                hariAntar = "Rabu";
                break;

            case "marie curie":
            case "louis pasteur":
                hariJemput = "Jumat";
                hariAntar = "Sabtu";
                break;

            case "archimedes":
                hariJemput = "Senin";
                hariAntar = "Selasa";
                break;

            default:
                hariJemput = "Tidak diketahui";
                hariAntar = "Tidak diketahui";
        }
    }

    public void tambahPakaian(String namaPakaian, int jumlah) {
        daftarPakaian.add(namaPakaian + " (" + jumlah + ")");
        totalItem += jumlah;
    }

    public void tampilkanDetail() {
        System.out.println("\n===== DETAIL ORDER LAUNDRY =====");
        System.out.println("ID Order (NIM)  : " + nim);
        System.out.println("Nama Mahasiswa  : " + nama);
        System.out.println("Asrama          : " + asrama);
        System.out.println("Hari Jemput     : " + hariJemput);
        System.out.println("Hari Antar      : " + hariAntar);

        System.out.println("\nDaftar Laundry:");
        for (String pakaian : daftarPakaian) {
            System.out.println("- " + pakaian);
        }

        System.out.println("Total Item      : " + totalItem);
        System.out.println("Keluhan         : " + keluhan);
        System.out.println("Status          : Diproses");
        System.out.println("=================================");
    }
}

public class Driver3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM LAUNDRY MAHASISWA IT DEL ===");

        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Asrama: ");
        String asrama = input.nextLine();

        System.out.print("Masukkan Keluhan (jika tidak ada ketik '-'): ");
        String keluhan = input.nextLine();

        LaundryOrder order = new LaundryOrder(nim, nama, asrama, keluhan);

        // Input daftar pakaian
        String lanjut;
        do {
            System.out.print("\nNama Pakaian: ");
            String namaPakaian = input.nextLine();

            System.out.print("Jumlah: ");
            int jumlah = input.nextInt();
            input.nextLine(); // buang enter

            order.tambahPakaian(namaPakaian, jumlah);

            System.out.print("Tambah pakaian lagi? (y/n): ");
            lanjut = input.nextLine();

        } while (lanjut.equalsIgnoreCase("y"));

        order.tampilkanDetail();
        input.close();
    }
}