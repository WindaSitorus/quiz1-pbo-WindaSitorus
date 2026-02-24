import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Input jumlah data
        System.out.print("Masukkan jumlah data: ");
        int N = input.nextInt();

        // 2. Buat array
        int[] nilai = new int[N];

        // 3. Input nilai
        System.out.println("Masukkan nilai siswa:");
        for (int i = 0; i < N; i++) {
            nilai[i] = input.nextInt();
        }

        // 4. Input kelompok yang ingin dihitung
        System.out.print("Masukkan kode kelompok: ");
        int k = input.nextInt();

        // 5. Hitung index awal
        int indexAwal = (k - 1) * k / 2;

        // Validasi jika kelompok tidak valid
        if (indexAwal >= N) {
            System.out.println("Kelompok tidak valid.");
        } else {

            int total = 0;
            int jumlahData = k;

            // 6. Menjumlahkan nilai kelompok
            for (int i = 0; i < jumlahData && (indexAwal + i) < N; i++) {
                total += nilai[indexAwal + i];
            }

            // 7. Output hasil
            System.out.println("Total nilai kelompok " + k + " adalah: " + total);
        }

        input.close();
    }
}