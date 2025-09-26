import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int n, m, max;
	private static int[][] board;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max = 0;
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, board[i][j]);
				visited[i][j] = false;
				checkShapeT(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
		
	private static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
			visited[nx][ny] = true;
			dfs(nx, ny, depth + 1,sum + board[nx][ny]);
			visited[nx][ny] = false;
		}
	}
	
	private static void checkShapeT(int x, int y) {
		int sum = board[x][y];
		
		// + 모양을 만들고
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

			sum += board[nx][ny];
		}
		
		// 상하좌우 하나씩 빼줬을 때(T자 모양 만들기) max
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
				max = Math.max(max, sum);
				continue;
			};
			
			max = Math.max(max, sum - board[nx][ny]);
		}
		
		return;
	}
}