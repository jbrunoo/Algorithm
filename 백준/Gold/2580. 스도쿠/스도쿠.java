import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static boolean dfs(int x, int y) {
		if (x == 9)
			return true;

		int nextX = (y == 8) ? x + 1 : x;
		int nextY = (y + 1) % 9;
		
		if (board[x][y] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (isValid(x, y, k)) {
					board[x][y] = k;
					if (dfs(nextX, nextY)) return true;
					board[x][y] = 0;
				}
			}
		} else {
			if (dfs(nextX, nextY)) return true;
		}

		return false;
	}

	private static boolean isValid(int x, int y, int num) {
		// row, col
		for (int i = 0; i < 9; i++) {
			if (board[i][y] == num)
				return false;
			if (board[x][i] == num)
				return false;
		}

		// box
		int row = x / 3;
		int col = y / 3;
		for (int i = row * 3; i < row * 3 + 3; i++) {
			for (int j = col * 3; j < col * 3 + 3; j++) {
//				System.out.println(i + " " + j);
				if (board[i][j] == num)
					return false;
			}
		}

		return true;
	}
}