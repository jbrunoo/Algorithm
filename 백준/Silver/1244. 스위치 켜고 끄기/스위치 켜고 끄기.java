import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                arr[i] = true;
            }
        }

        int s = Integer.parseInt(br.readLine());

        for (int student = 0; student < s; student++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = 1; i <= n; i++) {
                    if (i % cnt == 0) arr[i - 1] = !arr[i - 1];
                }
            }

            if (gender == 2) {
                int diff = 0;

                for (int i = 1; i < n / 2; i++) {
                    if (cnt - i - 1 < 0 || cnt + i - 1 >= n) {
                        break;
                    }
                    if (arr[cnt - i - 1] == arr[cnt + i - 1]) {
                        diff++;
                    } else {
                        break;
                    }
                }

                for (int i = cnt - diff - 1; i < cnt + diff; i++) {
                    arr[i] = !arr[i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i]) sb.append(1);
            else sb.append(0);

            if ((i + 1) % 20 == 0) sb.append("\n"); else if(i != n - 1) sb.append(" ");
        }

        System.out.print(sb);
    }
}
