import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		count = 0;
		recursion((int) Math.pow(2, N), 0, 0);
		System.out.println(count);
	}

	static void recursion(int n, int i, int j) {
		if (n == 1) {
			return;
		}
		int half = n / 2;
		if (r < i + half && c < j + half) {
			recursion(half, i, j);
		} else if (r < i + half && c >= j + half) {
			count += half * half;
			recursion(half, i, j + half);
		} else if (r >= i + half && c < j + half) {
			count += half * half * 2;
			recursion(half, i + half, j);
		} else {
			count += half * half * 3;
			recursion(half, i + half, j + half);
		}
	}
}