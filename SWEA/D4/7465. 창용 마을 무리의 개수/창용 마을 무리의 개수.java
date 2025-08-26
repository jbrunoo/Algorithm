import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {    
	
	private static int n;
	private static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			makeSet();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				union(from, to);
			}
			
			HashSet<Integer> set = new HashSet<>();
			
			for (int i = 1; i <= n; i++) {
				set.add(findSet(i));
			}
			
			sb.append("#").append(t).append(" ").append(set.size()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void makeSet() {
		parent = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if (parent[a] == a) return a;
		
		return parent[a] = findSet(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if (rootA == rootB) {
			return false;
		}
		
		parent[rootB] = rootA;
		return true;
	}
}