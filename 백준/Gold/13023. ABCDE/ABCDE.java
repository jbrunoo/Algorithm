import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private static int n, m;
	private static ArrayList<Integer>[] adj;
	private static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from].add(to);
			adj[to].add(from);
		}
		
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			if(dfs(i, 1)) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}


	private static boolean dfs(int start, int cnt) {
		if (cnt == 5) {
			return true;
		}
		visited[start] = true;
		
		for (int next : adj[start]) {
			if (visited[next]) continue;
			if(dfs(next, cnt + 1)) return true;
			visited[next] = false;
		}
		
		return false;
	}
	
	
}