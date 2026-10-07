package A000124;
import java.util.Scanner;

public class A000124 {
    
    public static int calculateA000124(int n) {
        return 1 + (n - 1) * n / 2;
    }
    
    public static String generateSequence(int n) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                result.append("-");
            }
            result.append(calculateA000124(i));
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Program A000124 Sloane's OEIS ===");
        System.out.print("Masukkan input (n): ");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid!");
                return;
            }
            
            int n = scanner.nextInt();
            
            if (n <= 0) {
                System.out.println("Masukkan angka positif yang valid!");
                return;
            }
            
            String result = generateSequence(n);
            System.out.println("\nInput: " + n);
            System.out.println("Output: " + result);
        } finally {
            scanner.close();
        }
    }
}