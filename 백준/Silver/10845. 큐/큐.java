import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
				case "push" : q.add(Integer.parseInt(st.nextToken())); break; 
				
				case "pop" : sb.append(q.isEmpty() ? -1 : q.pop()).append("\n"); break;
				
				case "size" : sb.append(q.size()).append("\n"); break;
				
				case "empty" : sb.append(q.isEmpty() ? 1 : 0).append("\n"); break;
				
				case "front" : sb.append(q.isEmpty() ? -1 : q.get(0)).append("\n"); break;
								
				case "back" : sb.append(q.isEmpty() ? -1 : q.getLast()).append("\n"); break;
			}		
		}
		
		System.out.println(sb);
	}
}
