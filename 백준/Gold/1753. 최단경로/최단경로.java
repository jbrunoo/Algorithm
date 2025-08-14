import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static class Vertex implements Comparable<Vertex> {
		int vertex, weight;
		Vertex link;
		
		public Vertex(int vertex, int weight, Vertex link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}
	
	private static Vertex[] adj;
	private static boolean[] visited;
	private static int[] distance;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		adj = new Vertex[V + 1];
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u] = new Vertex(v, w, adj[u]);
		}
		
		visited = new boolean[V + 1];
		distance = new int[V + 1];	
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		dijkstra(start);
		
		for(int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(distance[i]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dijkstra(int start) {
		distance[start] = 0;
		
		Queue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, distance[start], null));
		
		while (!pq.isEmpty()) {
			Vertex current = pq.poll();
			if (visited[current.vertex]) continue;
			
			if (current.vertex == -1) return;
			
			visited[current.vertex] = true;
			
			for (Vertex next = adj[current.vertex]; next != null; next = next.link) {
				if (!visited[next.vertex]
						&& distance[next.vertex] > current.weight + next.weight) {
					distance[next.vertex] = current.weight + next.weight;
					pq.offer(new Vertex(next.vertex, distance[next.vertex], null));
				}
			}
		}
	}
}