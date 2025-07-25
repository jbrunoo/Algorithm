import java.util.*;
import java.io.*;

public class Main {
    static int res = 0;
    static int m = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        combination(arr, 0, 3, 0);
        
        System.out.println(res);
    }
    
    static void combination(int[] arr, int begin, int r, int sum) {
        if (r == 0) {
           if (sum > res && sum <= m) res = sum;
            return;
        }
        
        for (int i = begin; i < arr.length; i++) {
            combination(arr, i + 1, r - 1, sum + arr[i]);
        }
    }
}