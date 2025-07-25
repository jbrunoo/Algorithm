import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int cnt = 1;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
		
			if (st.isEmpty() || st.peek() < num) {
				while(cnt <= num) {
					st.push(cnt);
					sb.append("+\n");
					cnt++;
				}
				st.pop();
				sb.append("-\n");				
			} else if (st.peek() > num) {
				System.out.println("NO");
				return;
			} else {
				st.pop();
				sb.append("-\n");
			}
		}
		
		System.out.println(sb);
	}
}