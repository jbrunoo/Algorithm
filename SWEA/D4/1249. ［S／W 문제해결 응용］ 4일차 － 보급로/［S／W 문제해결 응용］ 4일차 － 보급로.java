import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	
	private static int n;
	private static int[][] map;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String row = br.readLine();
				
				for (int j = 0; j < n; j++) {
					map[i][j] = row.charAt(j) - '0';
				}
			}
			
			int min = bfs();
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		System.out.println(sb);
	}
	
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	
	// bfs, memo
	private static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		int[][] minTimes = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(minTimes[i], Integer.MAX_VALUE);
		}
		minTimes[0][0] = 0;
		
		
		while (!q.isEmpty()) {			
			Integer p = q.poll();
			int x = p / 1000;
			int y = p % 1000;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if (minTimes[nx][ny] > minTimes[x][y] + map[nx][ny]) {
					minTimes[nx][ny] = minTimes[x][y] + map[nx][ny];
//					System.out.println("nx ny :" + nx + " " + ny + " " + minTimes[nx][ny]);
					q.offer(nx * 1000 + ny);
					
				}
			}
		}
		
		return minTimes[n-1][n-1];
	}
}