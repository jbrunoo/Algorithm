import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    private static int n, m;
    private static Pos start;
    private static char[][] maze;
    private static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new char[n][m];
        visited = new boolean[n][m][1 << 6];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                if (row[j] == '0') {
                    start = new Pos(i, j, 0, 0);
                }
                maze[i][j] = row[j];
            }
        }

        int ret = bfs();
        System.out.println(ret);
    }

    // 아이디어
    // bfs
    // 방문 처리 시 열쇠 소유
    // 열쇠 6개 2^6 비트마스킹

    private static int[] dx = { 1, -1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };

    private static int bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.x][start.y][start.bit] = true;

        while(!q.isEmpty()) {
            Pos current = q.poll();
            int x = current.x; int y = current.y; int bit = current.bit; int move = current.move;
//            System.out.println(current);
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny][bit] || maze[nx][ny] == '#') continue;
                if (maze[nx][ny] == '1') return move + 1;

                if ('A' <= maze[nx][ny] && maze[nx][ny] <= 'F') { // A-F
                    int door = maze[nx][ny] - 'A';
                    if ((bit & (1 << door)) != 0) { // 비트 켜져있는지
                        visited[nx][ny][bit] = true;
                        q.offer(new Pos(nx, ny, bit, move + 1));
                    }
                    continue;
                } else if ('a' <= maze[nx][ny] && maze[nx][ny] <= 'f') { // a-f 열쇠 발견
                    int updatedBit = bit | (1 << maze[nx][ny] - 'a'); // 비트 켜기
                    visited[nx][ny][updatedBit] = true;
                    q.offer(new Pos(nx, ny, updatedBit, move + 1));
                    continue;
                }

                visited[nx][ny][bit] = true;
                q.offer(new Pos(nx, ny, bit, move + 1));
            }
        }

        return -1;
    }
}

class Pos {
    int x, y, bit, move;

    Pos(int x, int y, int bit, int move) {
        this.x = x;
        this.y = y;
        this.bit = bit;
        this.move = move;
    }

    @Override
    public String toString() {
        return "x y bit move :" + x + " " + y + " " + bit + " " + move;
    }
}