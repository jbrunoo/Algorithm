import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	private static int n, m;
	private static int[][] board;
	private static boolean[][] visited;
	// 상 : 0, 하 : 1, 좌 : 2, 우 : 3
	private static int[][] block = {
			{ -1 },
			{ 0, 1, 2, 3 },
			{ 0, 1 },
			{ 2, 3 },
			{ 0, 3 },
			{ 1, 3 },
			{ 1, 2 },
			{ 0, 2 },
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			board = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < m; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(r, c, l);
			
			int place = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j]) place++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(place).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 상하좌우 순
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	
	private static void bfs(int r, int c, int l) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(r * 100 + c);
		visited = new boolean[n][m];
		visited[r][c] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			if (cnt == l) return;
			
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Integer next = q.poll();
				int x = next / 100;
				int y = next % 100;
//				System.out.println(x + " " + y + " " + cnt);
//				System.out.println("----");
				
				for (int i : block[board[x][y]]) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
					
					int blockIdx = board[nx][ny];
					if (blockIdx == 0) continue;
					
					for (int b : block[blockIdx]) {
						if ((i == 0 && b == 1) || (i == 1 && b == 0) || (i == 2 && b == 3) || (i == 3 && b == 2)) {
							visited[nx][ny] = true;
							q.offer(nx * 100 + ny);
							break;
						}
					}
				}
			}
			
			cnt++;
		}
		
		return;
	}
}