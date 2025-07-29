import java.util.*;

public class Main {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); int b = sc.nextInt();
		System.out.println(bfs(a, b));
	}
	
	static int bfs(int a, int b) {
		Queue<Pos> q = new LinkedList<>();
		boolean[] visited = new boolean[b];
		q.add(new Pos(a, 1));
		
		while (!q.isEmpty()) {
			Pos pos = q.poll();

			if (pos.a == b) return pos.cnt;
			if (pos.a > b) continue;
			
			q.add(new Pos(pos.a * 2, pos.cnt + 1));
			q.add(new Pos(pos.a * 10 + 1, pos.cnt + 1));
		}
		
		return -1;
		
	}
}

class Pos {
	long a; int cnt;
	
	Pos(long a, int cnt) {
		this.a = a;
		this.cnt = cnt;
	}
}