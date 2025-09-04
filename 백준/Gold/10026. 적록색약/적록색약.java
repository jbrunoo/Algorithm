import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int n;
	private static char[][] board;
	private static boolean[][] visited1;
	private static boolean[][] visited2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited1[i][j]) {
					dfs1(i, j, board[i][j]); 
					cnt1++;
				}
				if (!visited2[i][j]) {
					dfs2(i, j, board[i][j] == 'B');
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };
	
	private static void dfs1(int x, int y, char c) {
		visited1[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited1[nx][ny]) continue;
			if (board[nx][ny] == c) {
				dfs1(nx, ny, c);	
			}
		}
	}
	
	private static void dfs2(int x, int y, boolean b) {
		visited2[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited2[nx][ny]) continue;
			if ((b && board[nx][ny] == 'B') || (!b && board[nx][ny] != 'B')) {
				dfs2(nx, ny, b);				
			}
		}
	}
}