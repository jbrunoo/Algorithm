import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int k, n, m;
    private static int[][] board;
    private static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        visited = new boolean[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int[] x1 = { -1, 1, 0, 0 }; // monkey
    private static int[] y1 = { 0, 0, -1, 1 };
    private static int[] x2 = { -2, -1, -2, -1, 1, 2, 1, 2 }; // horse
    private static int[] y2 = { -1, -2, 1, 2, -2, -1, 2, 1 };

    private static int bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0, 0, k, 0));
        visited[0][0][k] = true;

        while(!q.isEmpty()) {
            Pos current = q.poll();
//            System.out.println(current);
            int x = current.x;
            int y = current.y;
            int jump = current.jump;
            int move = current.move;

            if (x == m - 1 && y == n - 1) return move;

            for (int i = 0; i < 4; i++) {
                int mx = x + x1[i];
                int my = y + y1[i];

                if (mx < 0 || my < 0 || mx >= m || my >= n || visited[mx][my][jump] || board[mx][my] == 1) continue;
                visited[mx][my][jump] = true;
                q.offer(new Pos(mx, my, jump, move + 1));
            }

            if (jump > 0) {
                for (int i = 0; i < 8; i++) {
                    int hx = x + x2[i];
                    int hy = y + y2[i];

                    if (hx < 0 || hy < 0 || hx >= m || hy >= n || visited[hx][hy][jump - 1] || board[hx][hy] == 1) continue;
                    visited[hx][hy][jump - 1] = true;
                    q.offer(new Pos(hx, hy, jump - 1, move + 1));
                }
            }
        }

        return -1;
    }
}

class Pos {
    int x, y, jump, move;

    Pos(int x, int y, int jump, int move) {
        this.x = x;
        this.y = y;
        this.jump = jump;
        this.move = move;
    }

    @Override
    public String toString() {
        return "x y jump move : " + x + " " + y + " " + jump + " " + move;
    }
}