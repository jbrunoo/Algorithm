import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	public int vertex;
	public Node link;

	Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
}

public class Main {
	private static int N;
	private static Node[] array;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		array = new Node[N];

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			array[from] = new Node(to, array[from]);
			array[to] = new Node(from, array[to]);
		}
		result = 0;

		for (int i = 0; i < N; i++) {
			dfs(i, 0, new boolean[N]);
			if (result == 1)
				break;
		}
		System.out.println(result);
	}

	private static void dfs(int current, int depth, boolean[] visited) {

		visited[current] = true;

		if (depth == 4) {
			result = 1;
			return;
		}

		for (Node temp = array[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(temp.vertex, depth + 1, visited);
			}
		}
		
		visited[current] = false;
	}
}