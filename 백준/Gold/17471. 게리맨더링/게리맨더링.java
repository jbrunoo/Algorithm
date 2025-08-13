import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int[] parents;
	private static int[] population;
	private static boolean[] district;
	private static ArrayList<Integer>[] adj;
	private static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		district = new boolean[N];
		adj = new ArrayList[N + 1];
		min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());	
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int from = 1; from <= N; from++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < cnt; i++) {
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				adj[to].add(from);
			}
		}
				
		subset(0);
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	private static void subset(int depth) {
		if (depth == N) {
			
			int divideCnt = 0;
			for (int i = 0; i < N; i++) {
				if (district[i]) divideCnt++;
				else divideCnt--;
			}
			
			if (divideCnt == N || divideCnt == -N) return;
			
			boolean flag1 = false;
			boolean flag2 = false;

			for (int i = 0; i < N; i++) {
				if (flag1 && flag2) break;
				if (district[i]) {
					flag1 = bfs(i + 1, district[i]);
				} else {
					flag2 = bfs(i + 1, district[i]);
				}
			}
			
			if (flag1 && flag2) {
				int ret = calcPop();
				if (min > ret) min = ret;
			}
			
			return;
		}
		
			district[depth] = true;
			subset(depth + 1);			
			district[depth] = false;
			subset(depth + 1);
	}

	private static boolean bfs(int start, boolean bool) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		q.offer(start);
		visited[start - 1] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int current = q.poll();
			
			for (int next : adj[current]) {
				if (district[next - 1] == bool && !visited[next - 1]) {
					cnt++;
					visited[next - 1] = true;
					q.offer(next);
				}
			}
		}
		
		int tempCnt = 0;
		for (boolean d : district) {
			if (d == bool) tempCnt++;
		}
		
		if (cnt == tempCnt) return true;
		return false;
	}
	
	private static int calcPop() {
		int first = 0;
		int second = 0;
		
		for (int i = 0; i < N; i++) {
			if (district[i]) first += population[i];
			else second += population[i];
		}
		
		return Math.abs(first - second);
	}
}