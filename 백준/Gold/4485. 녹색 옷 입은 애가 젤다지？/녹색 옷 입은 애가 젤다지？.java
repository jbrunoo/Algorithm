import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static class Pos implements Comparable<Pos> {
		int pos, weight;
		Pos link;
		
		public Pos(int pos, int weight, Pos link) {
			this.pos = pos;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public int compareTo(Pos o) {
			return this.weight - o.weight;
		}
	}
	
	private static int n;
	
	private static int[][] board;
	
	private static Pos[] cave;
	private static boolean[] visited;
	private static int[] distance;
	
	private static int[] di = { -1, 1, 0, 0 };
	private static int[] dj = { 0, 0, -1, 1 };
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = 0;
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			board = new int[n][n];
			cave = new Pos[n * n];
			visited = new boolean[n * n];
			distance = new int[n * n];
			Arrays.fill(distance, Integer.MAX_VALUE);
						
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for (int idx = 0; idx < n * n; idx++) {
				int i = idx / n;
				int j = idx % n;
				
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					
					if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;
					int neighborIdx = ni * n + nj;
					cave[cnt] = new Pos(neighborIdx, board[ni][nj], cave[cnt]);	
//					System.out.println("cnt" + cnt + " pos " + neighborIdx);
				}
				cnt++;
			}
//			cntt = 0;
			dijkstra();
//			System.out.println(cntt);
			
			sb.append("Problem ").append(++t).append(": ").append(distance[n * n - 1]).append("\n");
		}
		
		System.out.println(sb);
	}

//	private static int cntt;
	
	private static void dijkstra() {
		distance[0] = board[0][0];
		
		Queue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(0, distance[0], null));
		
		
		while (!pq.isEmpty()) {
			Pos current = pq.poll();
			
			if (visited[current.pos]) continue;
			visited[current.pos] = true;
			
			if (current.pos == n * n - 1) return;
			
//			cntt++;
			
			for (Pos next = cave[current.pos]; next != null; next = next.link) {
				if (!visited[next.pos] && distance[next.pos] > current.weight + next.weight) {
					distance[next.pos] = current.weight + next.weight;
					pq.offer(new Pos(next.pos, distance[next.pos], null));
				}
			}
		}
		
		return;
	}
}