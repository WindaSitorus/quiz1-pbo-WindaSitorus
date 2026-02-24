import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String kode;
        int porsiButet;
        int totalPembayaran = 0;

        System.out.println("Menu                 Porsi     Harga     Total");
        System.out.println("====================================================");

        while (true) {

            kode = input.nextLine();

            if (kode.equalsIgnoreCase("END")) {
                break;
            }

            porsiButet = input.nextInt();
            input.nextLine();

            String namaMenu = "";
            int harga = 0;

            switch (kode) {
                case "NGS":
                    namaMenu = "Nasi Goreng Spesial";
                    harga = 15000;
                    break;
                case "AP":
                    namaMenu = "Ayam Penyet";
                    harga = 20000;
                    break;
                case "SA":
                    namaMenu = "Sate Ayam";
                    harga = 25000;
                    break;
                case "BU":
                    namaMenu = "Bakso Urat";
                    harga = 18000;
                    break;
                case "MAP":
                    namaMenu = "Mie Ayam Pangsit";
                    harga = 15000;
                    break;
                case "GG":
                    namaMenu = "Gado-Gado";
                    harga = 15000;
                    break;
                default:
                    System.out.println("Kode tidak valid!");
                    continue;
            }

            // Perbandingan berat 2 : 1
            int totalPorsi = porsiButet * 3;

            int total = harga * totalPorsi;
            totalPembayaran += total;

            System.out.printf("%-20s %-10d %-10d %-10d\n",
                    namaMenu, totalPorsi, harga, total);
        }

        System.out.println("====================================================");
        System.out.println("Total Pembayaran : " + totalPembayaran);

        // ===== Sistem Kupon =====
        double diskon = 0;
        String jenisKupon = "Tidak Ada";

        if (totalPembayaran >= 300000) {
            diskon = 0.15;
            jenisKupon = "Kupon Merah (15%)";
        } else if (totalPembayaran >= 200000) {
            diskon = 0.10;
            jenisKupon = "Kupon Kuning (10%)";
        } else if (totalPembayaran >= 100000) {
            diskon = 0.05;
            jenisKupon = "Kupon Biru (5%)";
        }

        double potongan = totalPembayaran * diskon;
        double totalAkhir = totalPembayaran - potongan;

        System.out.println("Kupon              : " + jenisKupon);
        System.out.println("Diskon             : " + potongan);
        System.out.println("Total Bayar        : " + totalAkhir);

        input.close();
    }
}
