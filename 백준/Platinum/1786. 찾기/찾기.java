import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String T = br.readLine();
		String P = br.readLine();
		int lenT = T.length();
		int lenP = P.length();
		
		int[] pi = new int[lenP];
		
		for (int i = 1, j = 0; i < lenP; i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0, j = 0; i < lenT; i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (T.charAt(i) == P.charAt(j)) {
				if (j == lenP - 1) {
					cnt++;
					list.add(i - j);
					
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		
		sb.append(cnt).append("\n");
		if (cnt > 0) {
			for (Integer i : list) {
				sb.append(i + 1).append(" ");
			}
		}
		
		System.out.print(sb);
	}
}