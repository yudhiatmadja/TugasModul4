import java.util.Scanner;
import java.lang.Math;


public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Akar Kuadrat");
            System.out.println("2. Pangkat");
            System.out.println("3. Logaritma");
            System.out.println("4. Faktorial");
            System.out.println("5. Keluar");
            System.out.print("Pilih operasi (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan angka: ");
                    double numberSqrt = scanner.nextDouble();
                    System.out.println("Hasil akar kuadrat: " + Math.sqrt(numberSqrt));
                    break;
                case 2:
                    System.out.print("Masukkan angka: ");
                    double base = scanner.nextDouble();
                    System.out.print("Masukkan pangkat: ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Hasil pangkat: " + Math.pow(base, exponent));
                    break;
                case 3:
                    System.out.print("Masukkan angka: ");
                    double numberLog = scanner.nextDouble();
                    System.out.println("Hasil logaritma natural: " + Math.log(numberLog));
                    break;
                case 4:
                    System.out.print("Masukkan angka untuk faktorial: ");
                    int numberFactorial = scanner.nextInt();
                    System.out.println("Hasil faktorial: " + factorial(numberFactorial));
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
