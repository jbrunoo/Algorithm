import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[][] cave;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			cave = new int[n][n];
			if (n == 0) break;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem").append(" ").append(cnt).append(":").append(" ").append(dijkstra()).append("\n");
			cnt++;
		}
		
		System.out.println(sb);
	}
	
	private static int dijkstra() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(0, 0, cave[0][0]));
		int[][] dist = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);	
		}
		
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		while (!pq.isEmpty()) {
			Pos p = pq.poll();
			int x = p.x;
			int y = p.y;
			int k = p.k;
			
			if (k > dist[x][y]) continue;
			
			if (x == n - 1 && y == n - 1) return k;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i]; 
				int ny = y + dy[i]; 
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if (k + cave[nx][ny] < dist[nx][ny]) {
					dist[nx][ny] = k + cave[nx][ny];
					pq.offer(new Pos(nx, ny, dist[nx][ny]));
				}
			}
		}
		
		return -1;
	}
	
	private static class Pos implements Comparable<Pos> {
		int x, y, k;
		
		public Pos(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}

		@Override
		public int compareTo(Pos o) {
			return this.k - o.k;
		}
	}
}