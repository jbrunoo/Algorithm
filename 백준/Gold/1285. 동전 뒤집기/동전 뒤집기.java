import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n, min;
    private static int[][] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        coins = new int[n][n];

        for (int i = 0; i < n; i++){
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (row[j] == 'H') coins[i][j] = 0;
                else coins[i][j] = 1;
            }
        }

        subset(0);

        System.out.println(min);
    }

    private static void subset(int depth) {
        if (depth == n) {
            int tempMin = 0;

            for (int i = 0; i < n; i++) {
                int colCoins = 0;
                for (int j = 0; j < n; j++) {
                    if (coins[j][i] == 1) colCoins++;
                }
                if (colCoins > n / 2) tempMin += n - colCoins;
                else tempMin += colCoins;
            }

            min = Math.min(min, tempMin);

            return;
        }

        for (int j = 0; j < n; j++) {
            coins[depth][j] ^= 1;
        }
        subset(depth + 1);
        for (int j = 0; j < n; j++) {
            coins[depth][j] ^= 1;
        }
        subset(depth + 1);
    }
}