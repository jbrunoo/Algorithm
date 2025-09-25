import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] heights = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] original = new int[n];
		
		for (int i = 0; i < n; i++) {
			int idx = heights[i];
			int cnt = -1;
			
			for (int j = 0; j < n; j++) {
				if (original[j] == 0) {
					cnt++;
				}
				
				if (idx == cnt) {
					original[j] = i + 1;
					break;
				}
			}
		}
		
		for (int o : original) {
			System.out.print(o + " ");
		}
	}
}

// 2 1 1 0

// 0 0 0 0
// 0 0 1 0
// 0 2 1 0
// 0 2 1 3
// 4 2 1 3