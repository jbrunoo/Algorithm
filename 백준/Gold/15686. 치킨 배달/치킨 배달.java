import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private static int n, m, minDist;
	private static ArrayList<Point> house;
	private static ArrayList<Point> chicken;
	private static int[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		selected = new int[m];
		minDist = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					chicken.add(new Point(i, j));
				} else if (num == 1) {
					house.add(new Point(i, j));					
				}
			}
		}
		
		combination(0, 0);
		
		System.out.println(minDist);
	}
	
	private static void combination(int start, int depth) {
		if (depth == m) {
			minDist = Math.min(minDist, getMinDist(selected));
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			selected[depth] = i;
			combination(i + 1, depth + 1);
		}
	}
	
	private static int getMinDist(int[] selected) {
		int sum = 0;
		
		for (Point h : house) {
			int min = Integer.MAX_VALUE;
			
			for (int s : selected) {
				Point c = chicken.get(s);
				min = Math.min(min, getDist(h.x, h.y, c.x, c.y));				
			}
			
			sum += min;
		}
		
		return sum;
	}
	
	private static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}
}