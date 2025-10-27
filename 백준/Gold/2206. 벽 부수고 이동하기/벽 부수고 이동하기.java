import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	private static int n, m;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < row.length(); j++) {
				map[i][j] = row.charAt(j) - '0'; 
			}
		}
		
		System.out.println(bfs(0, 0));
	}
	
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	
	
	private static int bfs(int x, int y) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[n][m][2];
		q.offer(new Pos(x, y, 1, 1));
		visited[x][y][1] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if (p.x == n - 1 && p.y == m - 1) return p.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny][p.breakWall]) continue;
				if (map[nx][ny] == 1 && p.breakWall == 1) {
					q.offer(new Pos(nx, ny, 0, p.cnt + 1));
					visited[nx][ny][0] = true;
				}
				if (map[nx][ny] == 0) {
					q.offer(new Pos(nx, ny, p.breakWall, p.cnt + 1));					
					visited[nx][ny][p.breakWall] = true;
				}
			}
		}
		
		return -1;
	}
	
	private static class Pos {
		int x, y, breakWall, cnt;
		
		Pos(int x, int y, int breakWall, int cnt) {
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
			this.cnt = cnt;
		}
	}
}
