import java.io.*;
import java.util.*;

class Main {    
	static StringBuilder sb = new StringBuilder();
	static int[] result;
	
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    result = new int[n];
    
    combination(n, m, 1, 0);
	}   

	static void combination(int n, int m, int start, int idx) {
		if (m == 0) {
			for (int i = 0; i < result.length; i++) {
				if (result[i] == 0) continue;
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= n; i++) {
			result[idx] = i;
			combination(n, m - 1, i + 1, idx + 1);
		}
	}
}