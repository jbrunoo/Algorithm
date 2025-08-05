import java.util.Scanner;

public class Main {
	
	private static int n, m;
	private static int[] arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		arr = new int[m]; visited = new boolean[n];
		
		permutation(0);
		
		System.out.println(sb);
	}
	
	private static void permutation(int depth) {
		if (depth == m) {
			for (int i : arr) {
				sb.append(i + 1).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			arr[depth] = i;
			visited[i] = true;
			permutation(depth + 1);
			visited[i] = false;
		}
	}
}