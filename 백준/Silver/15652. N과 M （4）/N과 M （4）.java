import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		
		permutation(1, 0);
		System.out.println(sb);
	}
	
	private static void permutation(int start, int depth) {
		if (m == depth) {
			for (int i : arr) {
				sb.append(i).append(" ");	
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= n; i++) {
			arr[depth] = i;
			permutation(i, depth + 1);
		}
	}
}