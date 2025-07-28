import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Pos[] pos = new Pos[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(pos);
		
		for (Pos p : pos) {
			sb.append(p.x + " " + p.y).append("\n");
		}
		
		System.out.println(sb);
	}
}

class Pos implements Comparable<Pos> {
	int x, y;
	
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pos o) {
		if (this.x > o.x) {
			return 1;
		} else if (this.x < o.x) {
			return -1;
		} else {
			if (this.y > o.y) {
				return 1;
			} else if (this.y < o.y) {
				return -1;
			}
		}
		return 0;
	}
}