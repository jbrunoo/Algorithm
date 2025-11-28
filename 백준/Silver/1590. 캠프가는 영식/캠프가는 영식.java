import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (t <= s) {
				min = Integer.min(min, s - t);
			} else {
				for (int j = 1; j < c; j++) {
					int step = j * l;
					if (t <= s + step) {
						min = Integer.min(min, s + step - t);
						break;
					}
				}
			}
		}
		
		if (min == Integer.MAX_VALUE) min = -1;
		
		System.out.println(min);
	}
}