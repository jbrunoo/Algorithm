import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		int result = 0;
		int cnt = 0;
		
		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			if (str.contains("+")) {
				String[] arr = str.split("\\+");
				int sum = 0;
				for (String s : arr) {
					sum += Integer.parseInt(s);
				}
				if (cnt == 0) result += sum;
				else result -= sum;
			} else {
				int num = Integer.parseInt(str);
				if (cnt == 0) result += num;
				else result -= num;
			}
			cnt++;
		}
		
		System.out.println(result);
	}
}