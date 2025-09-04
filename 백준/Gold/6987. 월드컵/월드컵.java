import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static Country[] c;
	private static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			c = new Country[6];
			flag = false;
			boolean isMatchCnt5 = true;
			
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 6; j++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				
				if (win + draw + lose != 5) {
					isMatchCnt5 = false;
				}
				
				c[j] = new Country(win, draw, lose);
			}

			if (isMatchCnt5) dfs(0, 1, 0);
			System.out.print((flag ? 1 : 0) + " ");
		}
	}

	private static void dfs(int idx, int next, int depth) {
		
		if (flag) return;
		
		if (depth == 15) {
			flag = true;
			return;
		}
		
		if (next == 6) {
			dfs(idx + 1, idx + 2, depth);
			return;
		}
		
		Country c1 = c[idx];
		Country c2 = c[next];
			
		if (c1.win > 0 && c2.lose > 0) {
			c1.win--; c2.lose--;
			dfs(idx, next + 1, depth + 1);				
			c1.win++; c2.lose++;
		}
		if (c1.draw > 0 && c2.draw > 0) {
			c1.draw--; c2.draw--;
			dfs(idx, next + 1, depth + 1);
			c1.draw++; c2.draw++;
		}
		if (c1.lose > 0 && c2.win > 0) {
			c1.lose--; c2.win--;
			dfs(idx, next + 1, depth + 1);
			c1.lose++; c2.win++;
		}	
	}

	private static class Country {
		int win, draw, lose;

		public Country(int win, int draw, int lose) {
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}

		@Override
		public String toString() {
			return win + " " + draw + " " + lose;
		}
	}
}