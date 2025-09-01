import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int blueCount = recursion(0, 0, N, 1);
		int whiteCount = recursion(0, 0, N, 0);
		System.out.println(whiteCount + "\n" + blueCount);
	}

	public static int recursion(int r, int c, int k, int color) {
		boolean uniform = true;
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				if (board[i][j] != color) {
					uniform = false;
					break;
				}
			}
			if (!uniform)
				break;
		}
		if (!uniform) {
			int count = 0;
			count += recursion(r, c, k / 2, color);
			count += recursion(r, c + k / 2, k / 2, color);
			count += recursion(r + k / 2, c, k / 2, color);
			count += recursion(r + k / 2, c + k / 2, k / 2, color);
			return count;
		} else {
			return (board[r][c] == color) ? 1 : 0;
		}
	}
}
