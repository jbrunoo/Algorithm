import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, ret;
	private static Flavor[] flavors;
	private static boolean[] visited;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		ret = Integer.MAX_VALUE;
		
		flavors = new Flavor[n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			flavors[i] = new Flavor(s, b);
		}
		
		subset(0, 1, 0);
		
		System.out.println(ret);
	}

	private static void subset(int depth, int mul, int sum) {
		if (depth == n) {
			if (sum == 0 || mul == 1) return;
			
			int diff = Math.abs(mul - sum);
			if (ret > diff) ret = diff;
			return;
		}
		
		visited[depth] = true;
		subset(depth + 1, mul * flavors[depth].s, sum + flavors[depth].b);
		visited[depth] = false;
		subset(depth + 1, mul, sum);
	}
}

class Flavor {
	int s, b;
	
	Flavor(int s, int b) {
		this.s = s;
		this.b = b;
	}
}