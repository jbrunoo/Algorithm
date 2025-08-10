import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static List<Integer>[] adj;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        dfs(v);
        visited = new boolean[n + 1];
        sb.append("\n");
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        Collections.sort(adj[start]);
        for (int next : adj[start]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            int s = q.poll();
            if (visited[s]) continue;
            visited[s] = true;
            sb.append(s).append(" ");

            for (int next : adj[s]) {
                q.add(next);
            }
        }
    }
}