import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	public static int[][] magnet;
	public static int[] adjIdx; // 맞닿아 있는 위치
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());
			magnet = new int[5][8];
			adjIdx = new int[] { -20, 2, 6, 2, 6, 2, 6, -20 }; // target 기준 :1-right, 2-left, 2-right, 3-left, 3-right, 4-left // -1은 왼쪽 오른쪽 있는지 확인하기 귀찮아서
			
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 8; j++) {					
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			System.out.println(Arrays.toString(adjIdx));
//			System.out.println("-----");
		
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int target = Integer.parseInt(st.nextToken());
				int rotate = Integer.parseInt(st.nextToken());
				
				move(target, rotate);
				
//				System.out.println(Arrays.toString(adjIdx));
//				System.out.println("-----");
			}
			
			int ret = 0;
			if (magnet[1][(adjIdx[1] + 6) % 8] == 1) ret += 1;
			if (magnet[2][(adjIdx[2] + 2) % 8] == 1) ret += 2;
			if (magnet[3][(adjIdx[4] + 2) % 8] == 1) ret += 4;
			if (magnet[4][(adjIdx[6] + 2) % 8] == 1) ret += 8;
			
//			System.out.println(Arrays.toString(adjIdx));
			
			sb.append("#").append(t).append(" ").append(ret).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static HashSet<Integer> set = new HashSet<>();
	
	private static void move(int target, int rotate) {		
		set.add(target);
		
		// target 왼쪽
		for (int i = target; i > 1; i--) {
			if (magnet[i][adjIdx[(i - 1) * 2]] != magnet[i - 1][adjIdx[(i - 1) * 2 - 1]]) {
				set.add(i);
				set.add(i - 1);
			} else {
				break;
			}
		}
		
		// target 오른쪽
		for (int i = target; i < 4; i++) {
			if (magnet[i][adjIdx[(i - 1) * 2 + 1]] != magnet[i + 1][adjIdx[(i - 1) * 2 + 2]]) {
				set.add(i);
				set.add(i + 1);
			} else {
				break;
			}
		}
		
//		System.out.println("Set : " + set);
		
		for (Integer t : set) {
			if (Math.abs(target - t) % 2 == 0) {
				setRotate(t, rotate);
			} else {
				setRotate(t, -rotate);
			}
		}
		
		set.clear();
	}
	
	private static void setRotate(int target, int rotate) {		
		int targetAdjLeftIdx = (target - 1) * 2;
		int targetAdjRightIdx = (target - 1) * 2 + 1;
		
		if (rotate == 1) {
			adjIdx[targetAdjLeftIdx] = (adjIdx[targetAdjLeftIdx] + 7) % 8;
			adjIdx[targetAdjRightIdx] = (adjIdx[targetAdjRightIdx] + 7) % 8;
		} else {
			adjIdx[targetAdjLeftIdx] = (adjIdx[targetAdjLeftIdx] + 1) % 8;
			adjIdx[targetAdjRightIdx] = (adjIdx[targetAdjRightIdx] + 1) % 8;
		}
	}
}