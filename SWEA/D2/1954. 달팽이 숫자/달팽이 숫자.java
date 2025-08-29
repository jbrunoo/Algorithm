import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	private static int n;
	private static int[][] snail;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			n = Integer.parseInt(br.readLine());
			snail = new int[n][n];
			
			solution();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	private static int[] dx = { 0, -1, 0, 1 };
	private static int[] dy = { 1, 0, -1, 0 };
	
	
	private static void solution() {
		
		int cnt = 1;
		int x = 0; int y = 0;
		int d = 0;
		snail[x][y] = cnt;
		
		while (cnt != n * n) {
			x += dx[d];
			y += dy[d];

			if (x < 0 || y < 0 || x >= n || y >= n || snail[x][y] != 0) {
				x -= dx[d];
				y -= dy[d];
				d = (d + 1) % 4;
				continue;
			}
			
			snail[x][y] = ++cnt;
		}
	}
}

// 00 01 02 . 12 22. 21 20. 10. 11