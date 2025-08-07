import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Cook{
	private int S;
	private int B;
	
	public Cook(int s, int b) {
		this.S = s;
		this.B = b;
	}
	
	public void setS(int S) {this.S = S;}
	public void setB(int B) {this.B = B;}
	public int getS() {return S;}
	public int getB() {return B;}
}

public class Main {
	private static int N; // 원소의 개수
	private static Cook[] input; // 입력받은 원소들
	private static boolean[] isSelected; // 부분집합에 포함 여부
	
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		input = new Cook[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			int s = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			input[i] = new Cook(s, b);
		}

		generateSubSet2(0, 1, 0);
		System.out.println(min);
		
	}
	
	private static void generateSubSet2(int cnt, int mul, int sum) {
		
		// 기저 부분
		if (cnt == N) { // 모든 원소를 고려
			
			for(int i=0; i<isSelected.length; i++) {
				if(isSelected[i]) break;
				if(i==isSelected.length-1) return;
			}
			
			if (min>Math.abs(mul-sum)) {
				min = Math.abs(mul-sum);
			}
			return;
		}

		// 유도 부분
		// 현재 원소를 부분집합에 포함
		isSelected[cnt] = true;
		generateSubSet2(cnt + 1, mul*input[cnt].getS(), sum + input[cnt].getB());

		// 현재 원소를 부분집합에 미포함
		isSelected[cnt] = false;
		generateSubSet2(cnt + 1, mul, sum);
	}
}