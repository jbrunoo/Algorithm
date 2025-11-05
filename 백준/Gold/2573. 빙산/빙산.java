import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int N, M;
	private static int[][] sea;
	private static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sea = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		int year = 0;
		
		while (true) {
			year++;
			melt();
			if(check() == -1) {
				System.out.print(0);
				return;
			} else if (check() == 1) {
				System.out.println(year);
				return;
			}
		}
	}
	
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	
	private static void melt() {
		int[][] melted = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sea[i][j] != 0) {
					int water = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if (sea[nx][ny] == 0) water++;
					}
					melted[i][j] = Math.max(0,  sea[i][j] - water);
				}
			}
		}
		
		sea = melted;
	}
	
	private static boolean[][] visited;
	
	private static int check() {
		visited = new boolean[N][M];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sea[i][j] != 0 && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					dfs(i, j);
				}
				if (cnt > 1) return 1;
			}
		}
		
		if (cnt == 0) return -1;
		return 0;
	}
	
	private static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || sea[nx][ny] == 0) continue;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}