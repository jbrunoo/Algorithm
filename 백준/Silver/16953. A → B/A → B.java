import java.util.*;

public class Main {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong(); int b = sc.nextInt();
		System.out.println(bfs(a, b));
	}
	
	static int bfs(long a, int b) {
		Queue<Long> q = new LinkedList<>();
		q.add(a);
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				long n = q.poll();
				if (n == b) return cnt;
				if (n > b) continue;
				
				q.add(n * 2);
				q.add(n * 10 + 1);
			}
			cnt++;
		}
		
		return -1;
		
	}
}
