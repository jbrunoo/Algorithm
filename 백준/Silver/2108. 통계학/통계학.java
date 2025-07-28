import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int res1 = 0; int res2; int res4;
		
		for (int a : num) res1 += a;
			
		Arrays.sort(num);
		res2 = num[n / 2];
		res4 = num[n - 1] - num[0];
		
		int[] cnt = new int[8001];
		
		for (int j = 0; j < n; j++) {
			cnt[num[j] + 4000]++;
		}
		
		int freqMax = 0;
		ArrayList<Integer> freqIdx = new ArrayList<>();
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] >= freqMax) {
				if (cnt[i] > freqMax) {
					freqMax = cnt[i];
					freqIdx.clear();
				}
				freqIdx.add(i - 4000);
			}
		}
		
		int freq = 0;
		if (freqIdx.size() == 1) freq = freqIdx.get(0); else freq = freqIdx.get(1);
		
		System.out.println(Math.round((double) res1 / num.length));
		System.out.println(res2);
		System.out.println(freq);
		System.out.println(res4);
	}
}