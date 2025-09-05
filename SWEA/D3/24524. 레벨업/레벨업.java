import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int n, minDist;
	private static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			minDist = Integer.MAX_VALUE;
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, -1, 0);
			
			sb.append(minDist).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// skipStatus : -1 skip 전, 0 이전 depth skip, 1 skip 계산 끝
	private static void dfs(int depth, int skipStatus, int dist) {
		if (minDist < dist) {
			return;
		}
		
		if (depth == n - 1) {
			minDist = Math.min(minDist, dist);
			return;
		}
		
		if (skipStatus == -1 && depth + 1 != n - 1
				) {
			dfs (depth + 1, 0, dist);
		}
		
		if (skipStatus == 0) {
			dfs (depth + 1, 1, dist + getDist(depth - 1, depth + 1));			
		} 
		if (skipStatus != 0) {
			dfs (depth + 1, skipStatus, dist + getDist(depth, depth + 1));
		}
	}
	
	private static int getDist(int x1, int x2) {
		return Math.abs(arr[x2] - arr[x1]);
	}
}