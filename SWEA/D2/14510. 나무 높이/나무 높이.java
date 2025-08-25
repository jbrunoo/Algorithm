import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {    
	
	private static int n;
	private static int[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			tree = new int[n];
			int maxHeight = 0;
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());;
				if (tree[i] > maxHeight) maxHeight = tree[i];
			}
			
			int days = 0;	
			int even = 0;
			int odd = 0;
			
			for (int i = 0; i < n; i++) {
				int diff = maxHeight - tree[i];
				even += diff / 2;
				odd += diff % 2;
			}
			
			while (even - odd > 1) {
				even--;
				odd += 2;
			}
			
			if (even >= odd) {
				days = odd * 2 + (even - odd) * 2;
			} else {
				days = even * 2 + (odd - even) * 2 - 1;
			}
			
			sb.append("#").append(t).append(" ").append(days).append("\n");
		}
		
		System.out.println(sb);
	}
}