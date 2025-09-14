import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int r, c, max;
    private static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        max = 0;
        board = new int[r][c];

        for (int i = 0; i < r; i++) {
            char[] row = br.readLine().toCharArray();

            for (int j = 0; j < c; j++) {
                board[i][j] = row[j] - 'A';
            }
        }
        
        dfs(0, 0, 1 << board[0][0], 1);

        System.out.println(max);
    }

    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    private static void dfs(int x, int y, int bit, int cnt) {
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

            if ((bit & (1 << board[nx][ny])) < 1) {
                dfs (nx, ny, bit | (1 << board[nx][ny]), cnt + 1);
            }
        }
    }
}