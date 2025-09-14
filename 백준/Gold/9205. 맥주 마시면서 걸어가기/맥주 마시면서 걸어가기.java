import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    private static int n;
    private static Point[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            pos = new Point[n + 2];

            st = new StringTokenizer(br.readLine());
            pos[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));


            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                pos[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            pos[n + 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append(bfs(pos[0]) ? "happy" : "sad").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(Point home) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(home);
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();

            if (getDist(current.x, current.y, pos[n + 1].x, pos[n + 1].y) <= 1000) return true;

            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;

                if (getDist(current.x, current.y, pos[i].x, pos[i].y) <= 1000) {
                    visited[i] = true;
                    q.offer(pos[i]);
                }
            }
        }

        return false;
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}