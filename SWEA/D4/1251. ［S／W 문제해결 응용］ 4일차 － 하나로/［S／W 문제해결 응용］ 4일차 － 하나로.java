import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	private static class Vertex implements Comparable<Vertex> {
		int no;
		long cost;
		
		public Vertex(int no, long cost) {
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	private static int n; // 정점
	private static int[] xs, ys;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			xs = new int[n];
			ys = new int[n];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					if (i == 0) {
						xs[j] = Integer.parseInt(st.nextToken());
					} else {
						ys[j] = Integer.parseInt(st.nextToken());	
					}
				}
			}
			double E = Double.parseDouble(br.readLine());
			
			sb.append("#").append(t).append(" ").append(Math.round(prim() * E)).append("\n");
		}

		System.out.println(sb);
	}
	
	// MST
	private static long prim() {
		long[] minEdge = new long[n - 1];
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;
		
		Queue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(0, 0));
		
		boolean[] visited = new boolean[n];
		
		long result = 0;
		int cnt = 0;
		
		while (!pq.isEmpty()) {
			Vertex current = pq.poll();
			
			if (visited[current.no]) continue;
			visited[current.no] = true;
			
			result += current.cost;
			
			if (++cnt == n) return result;
			
			for (int i = 0; i < n; i++) {
				if (visited[i]) continue;
				long cost = getDist(xs[current.no], ys[current.no], xs[i], ys[i]);
				pq.offer(new Vertex(i, cost));
			}
			
		}
		
		return result;
	}
	
	private static long getDist(int x1, int y1, int x2, int y2) {
		long x = Math.abs(x2 - x1);
		long y = Math.abs(y2 - y1);
		return (x * x) + (y * y);
	}
}