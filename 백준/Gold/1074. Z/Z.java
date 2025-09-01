import java.util.Scanner;

public class Main {
	static int N;
	static int r, c;
	static int count;
	static boolean more;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		sc.close();
		count = 0;
		more = true;
		recursion((int) Math.pow(2, N), 0, 0);
		System.out.println(count);
	}

	static void recursion(int n, int x, int y) {
		if (n == 1)
			return;
		int half = n / 2;
		if (r < x + half && c < y + half) {
			recursion(half, x, y);
		} else if (r < x + half && c >= y + half) {
			count += half * half;
			recursion(half, x, y + half);
		} else if (r >= x + half && c < y + half) {
			count += half * half * 2;
			recursion(half, x + half, y);
		} else {
			count += half * half * 3;
			recursion(half, x + half, y + half);
		}
	}
}