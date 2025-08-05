import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> li = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		permutation(n, m, 1);
		System.out.println(sb);
	}
	
	private static void permutation(int n, int m, int start) {
		if (m == 0) {
			for (int i : li) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= n; i++) {
			li.add(i);
			permutation(n, m - 1, i);
			li.remove(li.size() - 1);
		}
	}
}