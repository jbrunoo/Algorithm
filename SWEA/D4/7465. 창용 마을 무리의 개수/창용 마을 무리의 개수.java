import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	private static int n, m;
	private static int[] parents;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n];
		
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}
			
			for (int i = 0 ; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				union(from - 1, to - 1);
			}
			
			HashSet<Integer> set = new HashSet<>();
			
			for (int i : parents) {
				set.add(findSet(i));
			}
			
			sb.append("#").append(t).append(" ").append(set.size()).append("\n");
		}

		System.out.println(
				sb);
	}
	
	private static int findSet(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}