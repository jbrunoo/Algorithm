import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String P = st.nextToken();
		String T = st.nextToken();
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < T.length() - P.length() + 1; i++) {
			int cnt = 0;
			for (int j = 0; j < P.length(); j++) {
				if (P.charAt(j) != T.charAt(j + i)) {
					cnt++;
				}
			}
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	}
}