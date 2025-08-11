import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {
	
	private static int n;
	private static int[][] arr, visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n]; 
		visited = new int[n][n]; 
		
		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				arr[i][j] = row[j] - '0';
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> cnts = new ArrayList<>();
 		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0 || visited[i][j] == 1) continue;
				cnt++;
				cnts.add(bfs(i, j));
			}
		}
		
		sb.append(cnt).append("\n");
		Collections.sort(cnts);
		for (int c : cnts) {
			sb.append(c).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	
	private static int bfs(int a, int b) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(100 * a + b);
		visited[a][b] = 1;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int current = q.poll();
			int x = current / 100; int y = current % 100;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] == 1 || arr[nx][ny] == 0) continue;
				visited[nx][ny] = 1;
				q.add(nx * 100 + ny);
			cnt++;
			}		
		}		
		
		return cnt;
	}
}