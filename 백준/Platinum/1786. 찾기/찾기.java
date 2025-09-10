import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		String P = br.readLine();
		
		int lenT = T.length();
		int lenP = P.length();
		
		int[] next = new int[lenP];
		
		int len = 0;
		for (int i = 1; i < lenP; i++) {
			while (len > 0 && P.charAt(len) != P.charAt(i)) {
				len = next[len - 1];
			}
			
			if (P.charAt(len) == P.charAt(i)) {
				next[i] = ++len;
			} 
//			else {
//				next[i] = 0;
//			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0, j = 0; i < lenT; i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = next[j - 1];
			}
			
			if (T.charAt(i) == P.charAt(j)) {
				if (j == lenP - 1) {
					cnt++;
					list.add(i - (lenP - 1));
					j = next[j];
				} else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		if (cnt > 0) {
			for (Integer i : list) {
				System.out.print((i + 1) + " ");
			}
		}
	}
}