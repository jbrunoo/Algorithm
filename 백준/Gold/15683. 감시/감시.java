import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[][] space;
    private static int[][] spacecopy;
    private static int[] dx = {0, 1, 0, -1}; // 시계방향 : 좌0 하1 우2 상3
    private static int[] dy = {1, 0, -1, 0};
    private static int[][][] direction =
            {
                    { {0}, {1}, {2}, {3} },
                    { {0, 2}, {1, 3} },
                    { {3, 2}, {2, 1}, {1, 0}, {0, 3} },
                    { {0, 3, 2}, {3, 2, 1}, {2, 1, 0}, {1, 0, 3} },
                    { {0, 1, 2, 3} }
            };

    private static class CCTV {
        int x, y, type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type - 1;
        }
    }

    private static List<CCTV> cctv;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        space = new int[n][m];
        spacecopy = new int[n][m];
        cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                space[i][j] = num;
                spacecopy[i][j] = num;
                if (1 <= num && num <= 5) cctv.add(new CCTV(i, j, num));
            }
        }

        dfs(0);

        System.out.println(min);
    }

    private static void dfs(int depth) {
        if (depth == cctv.size()) {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (spacecopy[i][j] == 0) cnt++;
                    if (cnt > min) return;
                }
            }

            min = Math.min(min, cnt);

            return;
        }

        CCTV c = cctv.get(depth);
        for (int[] direc : direction[c.type]) {

            setCheck(c, direc, false);
            dfs(depth + 1);
            setCheck(c, direc, true);
        }
    }

    private static void setCheck(CCTV c, int[] direc, boolean recover) {
        for (int d : direc) {
            int nx = c.x + dx[d];
            int ny = c.y + dy[d];

            while (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (spacecopy[nx][ny] == 6) {
                    break;
                }
                if (spacecopy[nx][ny] <= 0 && !recover) spacecopy[nx][ny] -= 1;
                if (spacecopy[nx][ny] < 0 && recover) spacecopy[nx][ny] += 1;
                nx += dx[d];
                ny += dy[d];
            }
        }
    }
}
