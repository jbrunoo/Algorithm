import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(count(0, 0, N, 0));
		System.out.println(count(0, 0, N, 1));
	}

	static int count(int i, int j, int n, int color) {
		boolean uniform = true;
		loop: for (int a = i; a < i + n; a++) {
			for (int b = j; b < j + n; b++) {
				if (paper[a][b] != color) {
					uniform = false;
					break loop;
				}
			}
		}
		if (!uniform) {
			int c = 0;
			c += count(i, j, n / 2, color);
			c += count(i + n / 2, j, n / 2, color);
			c += count(i, j + n / 2, n / 2, color);
			c += count(i + n / 2, j + n / 2, n / 2, color);
			return c;
		} else {
			return paper[i][j] == color ? 1 : 0;
		}
	}
}