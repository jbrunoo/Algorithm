import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {    
	
	private static int w, h, island;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			island = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {	
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						visited[i][j] = true;
						dfs(i, j);
						island++;
					}
				}
			}
			
			sb.append(island).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	private static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
	
	private static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || map[nx][ny] == 0) continue; 
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}