import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N;  // 물이 새는 곳의 개수
	private static int L;  // 테이프의 길이
	private static int[] loc;  // 물이 새는 곳의 위치 저장 배열
	private static boolean[] blocked;
	private static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		loc = new int[N];
		int maxVal = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(loc);
		maxVal = loc[N - 1];
		blocked = new boolean[maxVal + L];
		
		
		cnt = 0;
		for (int idx : loc) {
			if(!blocked[idx]) {	
				for (int j = 0; j < L; j++) {
					blocked[idx + j] = true; 
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}