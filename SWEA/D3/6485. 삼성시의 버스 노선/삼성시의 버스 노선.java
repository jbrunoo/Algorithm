import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int t = 1; t <= T; t++) {
             int[] arr = new int[5001];
             
			 sb.append("#").append(t).append(" ");
			 int n = Integer.parseInt(br.readLine());
			 
			 for(int i = 0; i < n; i++) {
				 st = new StringTokenizer(br.readLine());
				 int s = Integer.parseInt(st.nextToken());
				 int e = Integer.parseInt(st.nextToken());
				 
				 for(int j = s; j < e + 1; j++) {
					 arr[j]++;
				 }				 
			 }
			 
			 int p = Integer.parseInt(br.readLine());
			 
			 for(int i = 0; i < p; i++) {
				 int c = Integer.parseInt(br.readLine());
				 sb.append(arr[c]).append(" ");
			 }
			 sb.append("\n");
		 }
		 
		 System.out.print(sb);
	}
}