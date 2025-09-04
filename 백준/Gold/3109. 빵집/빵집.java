import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int r, c, max;
	private static char[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		max = 0;
		board = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < r; i++) {
			dfs(i, 0);
		}
		
		System.out.println(max);
	}
	
	private static int[] dx = { -1, 0, 1 };
	private static int[] dy = { 1, 1, 1 };
	
	private static boolean dfs(int x, int y) {
		if (y == c - 1) {
			max++;
			return true;
		}
		
		board[x][y] = 'p';
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= r || ny >= c || board[nx][ny] == 'x' || board[nx][ny] == 'p') continue;
			if (dfs (nx, ny)) return true;
		}
		
		return false;
	}
}