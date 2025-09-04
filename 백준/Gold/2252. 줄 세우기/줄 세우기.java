import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static class Node {
		int vertex;
		Node link;
		
		public Node (int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	private static int n, m;
	private static Node[] adj;
	private static int[] degree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new Node[n + 1];
		degree = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from] = new Node(to, adj[from]);
			degree[to]++;
		}
		
		List<Integer> list = solution();
				
		for (Integer i : list) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
	
	private static List<Integer> solution() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 1; i < n + 1; i++) {
			if (degree[i] == 0) q.offer(i);
		}
				
		while (!q.isEmpty()) {
			int student = q.poll();
			orderList.add(student);
			
			for (Node temp = adj[student]; temp != null; temp = temp.link) {
				if (--degree[temp.vertex] == 0) {
					q.offer(temp.vertex);
				}
			}
		}
		
		return orderList;
	}
}