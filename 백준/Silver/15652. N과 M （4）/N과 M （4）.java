import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
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