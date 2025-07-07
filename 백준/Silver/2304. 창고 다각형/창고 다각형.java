import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        int end = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[l] = h;
            if (end < l) end = l;
        }

        int sum = 0;

        int prev1 = 0;
        int h = 0;

        for(int i = 0; i < end + 1; i++) {
            if(h < arr[i]) {
                sum += h * (i - prev1);

                h = arr[i];
                prev1 = i;
            }
        }

        h = 0;
        int prev2 = end;

        for(int i = end; i > 0; i--) {
            if(h < arr[i]) {
                sum += h * (prev2 - i);

                h = arr[i];
                prev2 = i;
            }
        }

        System.out.print(sum + (prev2 - prev1 + 1) * h);
    }
}