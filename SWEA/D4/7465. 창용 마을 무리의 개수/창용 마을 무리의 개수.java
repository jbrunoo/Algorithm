import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {    
	
	private static ArrayList<Integer>[] adj;
	private static boolean[] connected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n + 1];
			connected = new boolean[n + 1];
			
			for (int i = 1; i < n + 1; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adj[from].add(to);
				adj[to].add(from);
			}
			
			int ret = 0;
			
			for (int i = 1; i <= n; i++) {
				if (connected[i]) continue;
				
				if (adj[i].isEmpty()) {
					ret++;
					continue;
				}
				dfs(i);
				ret++;
			}
			
			sb.append("#").append(t).append(" ").append(ret).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int start) {
		connected[start] = true;
		
		for (int next : adj[start]) {
			if (connected[next]) continue;
			dfs(next);
		}
	}
}