import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(in.readLine());

		int num;

		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(in.readLine());
			if (num != 0) {
				queue.offer(num);
			}
			else if(queue.isEmpty()) {
				System.out.println(0);
			} else {
				System.out.println(queue.poll());
			}
		}
	}
}