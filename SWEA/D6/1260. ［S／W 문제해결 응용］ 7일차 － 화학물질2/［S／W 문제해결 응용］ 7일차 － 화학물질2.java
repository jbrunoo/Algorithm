import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//2, 3 / 3, 4 / 4, 5
//행렬 곱 2 * 4 * 3 -> 24, 합쳐진 행렬 2, 4
//2, 4 / 4, 5
//행렬 곱 2 * 5 * 4 -> 40, 합쳐진 행렬 2, 5
//총 원소 곱 64

public class Solution {
	private static int n;
	private static int[][] matrix;

	private static class Matrix {
		int row, col; // 행과 열 길이

		public Matrix(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			matrix = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ret = solution();

			sb.append("#").append(t).append(" ").append(ret).append("\n");
		}

		System.out.println(sb);
	}

	private static int solution() {
		ArrayList<Matrix> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] > 0) {
					list.add(findMatrix(i, j));
				}
			}
		}

		int[] d = new int[list.size() + 1];
//		int[] counting = new int[n + 1];
//
//		for (Matrix m : list) {
//			counting[m.col]++;
//			counting[m.row]++;
//		}
//
//		for (int i = 0; i < n + 1; i++) {
//			if (counting[i] == 1) {
//				d[0] = i;
//				break;
//			}
//		}
		
		HashSet<Integer> setRow = new HashSet<>();
		HashSet<Integer> setCol = new HashSet<>();

		for (Matrix m : list) {
		    setRow.add(m.row);
		    setCol.add(m.col);
		}

		for (int r : setRow) {
		    if (!setCol.contains(r)) {
		        d[0] = r;
		        break;
		    }
		}

		for (int i = 0; i < d.length - 1; i++) {
			for (Matrix m : list) {
				if (d[i] == m.row) {
					d[i + 1] = m.col;
					break;
				}
			}
		}

//		System.out.println(Arrays.toString(d));
		
		int size = d.length - 1;

		int[][] dp = new int[size][size];

		for (int i = 0; i < size; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < size; i++) {
			dp[i][i] = 0;
		}
		
		for (int len = 1; len < size; len++) {
			for (int i = 0; i < size - len; i++) {
				int j = i + len;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + d[i] * d[k+1] * d[j+1]);
				}
//				System.out.println(Arrays.deepToString(dp));
			}
		}

		return dp[0][size-1];
	}

	private static Matrix findMatrix(int i, int j) {
		int x = i;

		while (x < n) {
			if (matrix[x][j] == 0)
				break;
			x += 1;
		}

		int y = j;

		while (y < n) {
			if (matrix[i][y] == 0)
				break;
			y += 1;
		}

//		System.out.println("findSet" + i + j + " " + x + y);

		// 찾은 행렬 부분 탐색안하게 0 초기화
		for (int a = i; a < x; a++) {
			for (int b = j; b < y; b++) {
				matrix[a][b] = 0;
			}
		}

		return new Matrix(x - i, y - j);
	}
}