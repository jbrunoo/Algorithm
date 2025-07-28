import java.io.*;
import java.util.*;

public class Main {
	static LinkedList<Integer> st;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		st = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			
			if (s.contains("push")) {
				push(Integer.parseInt(s.split(" ")[1]));
				continue;
			}
			
			switch (s) {
				case "pop" : pop(); break;
				case "size" : size(); break;
				case "empty" : empty(); break;
				case "top" : top(); break;
			}		
		}
		
		System.out.println(sb);
	}
	
	static void push(int x) {
		st.push(x);
	}
	
	static void pop() {
		if (st.isEmpty()) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(st.pop()).append("\n");
	}
	
	static void top() {
		if (st.isEmpty()) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(st.get(0)).append("\n");
	}
	
	static void size() {
		sb.append(st.size()).append("\n");
	}
	
	static void empty() {
		if (st.isEmpty()) {
			sb.append(1).append("\n");
			return;
		}
		else sb.append(0).append("\n");
	}
}
