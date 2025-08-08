import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int V; // 정점 개수
	private static int[][] adjMatrix; // 인접 행렬

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();

		adjMatrix = new int[V][V];

		int from, to;
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();

			adjMatrix[to-1][from-1] = adjMatrix[from-1][to-1] = 1;
		}
		dfs(start-1, new boolean[V]);
		System.out.println();
		bfs(start-1);
	}

	private static void dfs(int current, boolean[] visited) {

		visited[current] = true;

		System.out.print((current+1) + " ");

		for (int i = 0; i < V; i++) {
			if (adjMatrix[current][i] != 0 && !visited[i]) {
				dfs(i, visited);
			}
		}
	}
	
	private static void bfs(int start) {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];

		queue.offer(start);
		visited[start] = true; 

		int current = start;
		while (!queue.isEmpty()) {
			
			current = queue.poll();

			System.out.print((current+1) + " ");

			for (int i = 0; i < V; i++) {
				
				if (adjMatrix[current][i] != 0  
						&& !visited[i]) { 				
					
					queue.offer(i);
					visited[i] = true; 
				}
			}
		}
	}
}