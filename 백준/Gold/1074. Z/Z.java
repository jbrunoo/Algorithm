import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n, r, c, ret;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ret = -1;

		int len = getSize(n);

		z(0, 0, 0, len);

		System.out.println(ret);
	}

	// 한 변의 사이즈
	private static int getSize(int n) {
		int size = 1;
		for (int i = 0; i < n; i++) {
			size *= 2;
		}
		return size;
	}

	private static void z(int x, int y, int value, int len) {
		int half = len / 2;
		int v = half * half;

		if (x == r && y == c) {
			ret = value;
			return;
		}

		if (len == 1) return;

		if (x + half - 1 >= r && y + half - 1 >= c) {
			// 1사분면
			z(x, y, value, half);			
		} else if (x + half - 1 >= r && y + half <= c) {
			// 2사분면
			z(x, y + half, value + v, half);			
		} else if (x + half <= r && y + half - 1 >= c) {
			// 3사분면
			z(x + half, y, value + v * 2, len / 2);			
		} else {
			// 4사분면
			z(x + half, y + half, value + v * 3, len / 2);
		}
	}
}

// 4사분면으로 분할 해가면서 탐색 
// 좌상 우상 좌하 우하