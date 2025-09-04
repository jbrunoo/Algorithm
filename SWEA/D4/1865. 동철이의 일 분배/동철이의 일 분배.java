import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int n;
	private static double max;
	private static int[][] works;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			max = 0;
			works = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					works[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 1 << n, 1.0);
			double result = Math.round((max * 100 * 1000000));
			sb.append("#").append(t).append(" ").append(String.format("%.6f", result / 1000000)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int depth, int bit, double ret) {
		if (max >= ret) return;
		
		if (depth == n) {
			max = Math.max(max, ret);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if ((bit & (1 << i)) == 0) {
				dfs(depth + 1, bit | (1 << i), ret * works[depth][i] / 100);				
			}
		}
	}
}