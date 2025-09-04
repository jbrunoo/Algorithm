import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int n, m;
	private static ArrayList<Integer>[] adj;
	private static int[] degree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new ArrayList[n + 1];
		degree = new int[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
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
			
			for (int i = 0; i < adj[student].size(); i++) {
				int next = adj[student].get(i);
				if (--degree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		return orderList;
	}
}