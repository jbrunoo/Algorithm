import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] dp;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	dp = new int[m + 1][n + 1];
        	
        	for (int i = 1; i < m + 1; i++) {
        		for (int j = 0; j < n + 1; j++) {
        			if (j == i || j == 0) dp[i][j] = 1;
        			else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        		}
        	}
        	
        	sb.append(dp[m][n]).append("\n");
        }
        
        System.out.println(sb);
    }
}