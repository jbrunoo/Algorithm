import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	private static int n, x;
	private static int[][] arr;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(t).append(" ").append(solution()).append("\n");			
		}
		
		System.out.println(sb);
	}
	
	private static int solution() {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			// 가로
			int prev1 = arr[i][0];
			int needCnt1 = 0;
			int currentCnt1 = 0;
			boolean can1 = true;
			
			// 세로
			int prev2 = arr[0][i];
			int needCnt2 = 0;
			int currentCnt2 = 0;
			boolean can2 = true;
			
			for (int j = 0; j < n; j++) {
				// 가로
				if (prev1 != arr[i][j]) {
					if (Math.abs(prev1 - arr[i][j]) > 1) { // height
						can1 = false;
					}
					
					// 왼쪽이 더 큼
					if (prev1 > arr[i][j]) {
						if (currentCnt1 < needCnt1) {
							can1 = false;
						}
						needCnt1 = x;
					}
					// 오른쪽이 더 큼
					if (prev1 < arr[i][j]) {
						if (currentCnt1 - needCnt1 < x) {
							can1 = false;
						}
						needCnt1 = 0;
					}
					
					prev1 = arr[i][j];
					currentCnt1 = 1;
				} else {
					currentCnt1++;
				}
				
				// 세로
				if (prev2 != arr[j][i]) {
					if (Math.abs(prev2 - arr[j][i]) > 1) { // height
						can2 = false;
					}
					
					// 왼쪽이 더 큼
					if (prev2 > arr[j][i]) {
						if (currentCnt2 < needCnt2) {
							can2 = false;
						}
						needCnt2 = x;
					}
					// 오른쪽이 더 큼
					if (prev2 < arr[j][i]) {
						if (currentCnt2 - needCnt2 < x) {
							can2 = false;
						}
						needCnt2 = 0;
					}
					
					prev2 = arr[j][i];
					currentCnt2 = 1;
				} else {
					currentCnt2++;
				}
			}
			
			if (currentCnt1 < needCnt1) can1 = false;
			if (currentCnt2 < needCnt2) can2 = false;
			
			if (can1) cnt++;
//			System.out.println("i " + i + " cnt " + cnt);
			if (can2) cnt++;
//			System.out.println("i " + i + " cnt " + cnt);
		}
		
		return cnt;
	}

}