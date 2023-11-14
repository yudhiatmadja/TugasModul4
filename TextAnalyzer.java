import java.io.*;
import java.util.Scanner;

public class TextAnalyzer {
    private static String text = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Masukkan teks");
            System.out.println("2. Hitung jumlah karakter");
            System.out.println("3. Hitung jumlah kata");
            System.out.println("4. Cari kata dalam teks");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consuming the newline character

            switch (choice) {
                case 1:
                    masukkanTeks();
                    break;
                case 2:
                    hitungJumlahKarakter();
                    break;
                case 3:
                    hitungJumlahKata();
                    break;
                case 4:
                    cariKataDalamTeks(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih! Program berhenti.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }
        } while (choice != 5);
        
        scanner.close();
    }

    private static void masukkanTeks() {
        try {
            FileWriter fileWriter = new FileWriter("teks.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Masukkan teks: ");
            String inputText = scanner.nextLine();
            bufferedWriter.write(inputText);
            bufferedWriter.close();

            System.out.println("Teks berhasil disimpan ke dalam file 'teks.txt'");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan teks ke file.");
            e.printStackTrace();
        }
    }

    private static void hitungJumlahKarakter() {
        if (text.isEmpty()) {
            System.out.println("Anda belum memasukkan teks. Silakan masukkan teks terlebih dahulu.");
            return;
        }

        int jumlahKarakter = text.length();
        System.out.println("Jumlah karakter dalam teks: " + jumlahKarakter);
    }

    private static void hitungJumlahKata() {
        if (text.isEmpty()) {
            System.out.println("Anda belum memasukkan teks. Silakan masukkan teks terlebih dahulu.");
            return;
        }

        String[] kataArray = text.split("\\s+");
        int jumlahKata = kataArray.length;
        System.out.println("Jumlah kata dalam teks: " + jumlahKata);
    }

    private static void cariKataDalamTeks(Scanner scanner) {
        if (text.isEmpty()) {
            System.out.println("Anda belum memasukkan teks. Silakan masukkan teks terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan kata yang ingin dicari: ");
        String kataDicari = scanner.nextLine();

        String[] kataArray = text.split("\\s+");
        int jumlahKemunculan = 0;

        for (String kata : kataArray) {
            if (kata.equalsIgnoreCase(kataDicari)) {
                jumlahKemunculan++;
            }
        }

        System.out.println("Jumlah kemunculan kata '" + kataDicari + "' dalam teks: " + jumlahKemunculan);
    }
}

