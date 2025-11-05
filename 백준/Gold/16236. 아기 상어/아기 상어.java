import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int[][] sea;
	private static Shark sh;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 9) {
					sea[i][j] = 0;
					sh = new Shark(i, j, 2, 0, 0);
				}
				else sea[i][j] = num;
			}
		}
		
		while (true) {
			if(!searchFish(sh.x, sh.y)) {
				System.out.println(sh.dist);
				return;
			}
		}
	}
	
	private static int[] dx = { -1, 0, 0, 1 }; // 상 좌 우 하
	private static int[] dy = { 0, -1, 1, 0 };
	
	private static boolean searchFish(int a, int b) {
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(new Point(a, b));
		boolean[][] visited = new boolean[N][N];
		visited[a][b] = true;
		int[][] dist = new int[N][N];
		ArrayList<Point> fishes = new ArrayList<>();
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || sea[nx][ny] > sh.size) continue;
				visited[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1;
				
				if (sea[nx][ny] == sh.size || sea[nx][ny] == 0) {
					q.add(new Point(nx, ny));
				}
				else if (sea[nx][ny] < sh.size) {
					fishes.add(new Point(nx, ny));
					q.add(new Point(nx, ny));
				}
			}
		}
		if (!fishes.isEmpty()) {
			eatFish(fishes, dist);
			return true;
		}
		return false;
	}
	
	private static void eatFish(ArrayList<Point> list, int[][] dist) {
		list.sort((f1, f2) -> {
			int d1 = dist[f1.x][f1.y];
			int d2 = dist[f2.x][f2.y];
			if (d1 != d2) return Integer.compare(d1, d2);
			if (f1.x != f2.x) return Integer.compare(f1.x, f2.x);
			return Integer.compare(f1.y, f2.y);
		});
		
		Point fish = list.get(0);
		sh.x = fish.x;
		sh.y = fish.y;
		sh.dist += dist[fish.x][fish.y];
		if (sh.eat + 1 == sh.size) {
			sh.size += 1;
			sh.eat = 0;
		} else {
			sh.eat += 1;
		}
		sea[fish.x][fish.y] = 0;
	}
	
	private static class Shark {
		int x, y, size, eat, dist;
		
		public Shark(int x, int y, int size, int eat, int dist) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
			this.dist = dist;
		}
	}
}