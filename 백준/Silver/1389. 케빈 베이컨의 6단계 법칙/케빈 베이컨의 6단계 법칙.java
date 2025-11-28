import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int n, min;
	private static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		arr = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		int minPerson = -1;
		
		for (int i = 1; i < n + 1; i++) {
			int sum = bfs(i);
			if (min > sum) {
				min = sum;
				minPerson = i;
				
			}
			min = Math.min(min, bfs(i));
		}
		
		System.out.println(minPerson);
	}
	
	private static int bfs(int a) {
		Queue<Integer> q = new ArrayDeque<>();
		int[] dist = new int[n + 1];
		Arrays.fill(dist, -1);
		
		dist[a] = 0;
		q.offer(a);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : arr[cur]) {
				if (dist[next] == -1) {
					dist[next] = dist[cur] + 1;
					q.offer(next);
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += dist[i];
		}
		
		return sum;
	}
}