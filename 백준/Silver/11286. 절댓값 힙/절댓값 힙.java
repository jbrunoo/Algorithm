import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int v = Math.abs(o1) - Math.abs(o2);
				if (v == 0) return o1 - o2;
				else return v;	
			}
		});
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x != 0) q.offer(x);
			else {
				if (q.isEmpty()) sb.append(0).append("\n");
				else sb.append(q.poll()).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}