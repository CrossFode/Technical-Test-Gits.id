package DenseRanking;

import java.util.*;

public class DenseRanking {

    /**
     * 
     * @param leaderboard 
     * @param gitsScores 
     * @return 
     */
    public static List<Integer> denseRanking(int[] leaderboard, int[] gitsScores) {
        Set<Integer> uniqueSet = new TreeSet<>((a, b) -> b.compareTo(a)); 
        for (int score : leaderboard) {
            uniqueSet.add(score);
        }

        List<Integer> sortedUnique = new ArrayList<>(uniqueSet);
        List<Integer> ranks = new ArrayList<>();

        for (int score : gitsScores) {
            
            int rank = 1;
            for (int leaderScore : sortedUnique) {
                if (leaderScore > score) {
                    rank++;
                } else {
                    break;
                }
            }
            ranks.add(rank);
        }

        return ranks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Dense Ranking ===\n");

        System.out.print("Masukkan jumlah pemain: ");
        int n = scanner.nextInt();

        System.out.print("Masukkan skor pemain (dipisahkan spasi): ");
        int[] leaderboard = new int[n];
        for (int i = 0; i < n; i++) {
            leaderboard[i] = scanner.nextInt();
        }

        System.out.print("Masukkan jumlah permainan GITS: ");
        int m = scanner.nextInt();

        System.out.print("Masukkan skor GITS (dipisahkan spasi): ");
        int[] gitsScores = new int[m];
        for (int i = 0; i < m; i++) {
            gitsScores[i] = scanner.nextInt();
        }

        List<Integer> result = denseRanking(leaderboard, gitsScores);

        System.out.println("\n=== Hasil ===");
        System.out.print("Ranking GITS: ");
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();

        scanner.close();
    }
}