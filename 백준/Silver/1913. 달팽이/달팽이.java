import java.awt.*;
import java.util.Scanner;

public class Main {

    private static int n;
    private static int[][] table;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        int find = sc.nextInt();

        table = new int[n][n];
        table[n / 2][n / 2] = 1;

        solution();

        int x = 0; int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == find) {
                    x = i + 1; y = j + 1;
                }
                sb.append(table[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(x).append(" ").append(y);

        System.out.println(sb);
    }

    // 상 우 하 좌
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    // 진행한다음 진행 방향 기준 왼쪽이 비어있으면 시계방향 90도 꺽기
    private static void solution() {
        int cnt = 1;
        int x = n / 2; int y = n / 2;
        int d = 0;

        while (cnt != n * n) {
            x += dx[d];
            y += dy[d];

            table[x][y] = ++cnt;

            int leftDirection = (d + 1) % 4;
            if (table[x + dx[leftDirection]][y + dy[leftDirection]] == 0) {
                d = leftDirection;
            }
        }
    }
}