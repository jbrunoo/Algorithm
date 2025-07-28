import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Pos start = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 0) visited[i][j] = true;
                if (k == 1) map[i][j] = -1;
                if (k == 2) start = new Pos(i, j);
            }
        }

        bfs(start, map, visited);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static void bfs(Pos start, int[][] map, boolean[][] visited) {
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        map[start.x][start.y] = 0;
        visited[start.x][start.y] = true;


        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int x = pos.x; int y = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny]) continue;
                map[nx][ny] = map[x][y] + 1;
                visited[nx][ny] = true;
                q.add(new Pos(nx, ny));
            }
        }
    }
}

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}