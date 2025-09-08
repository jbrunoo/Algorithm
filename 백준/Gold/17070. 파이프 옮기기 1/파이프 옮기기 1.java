import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, cnt;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(cnt);
    }

    // 오른쪽, 오른쪽 대각선, 아래 // 45씩 회전 가능
    private static int[] dx = { 0, 1, 1 };
    private static int[] dy = { 1, 1, 0 };

    private static void dfs(int x, int y, int d) {
        if (x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (Math.abs(d - i) > 1) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;
            if (i == 1 && (board[nx - 1][ny] == 1 || board[nx][ny - 1] == 1)) continue;

            board[nx][ny] = 1;
            if (i == 1) {
                board[nx - 1][ny] = 1;
                board[nx][ny - 1] = 1;
            }

            dfs(nx, ny, i);

            board[nx][ny] = 0;
            if (i == 1) {
                board[nx - 1][ny] = 0;
                board[nx][ny - 1] = 0;
            }
        }
    }
}