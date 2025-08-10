import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[][] counting = new boolean[100][100];
        int sum = 0;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int s = x; s < x + 10; s++) {
                for (int e = y; e < y + 10; e++) {
                    if (!counting[s][e]) sum++;
                    counting[s][e] = true;
                }
            }
        }

        System.out.println(sum);
    }
}