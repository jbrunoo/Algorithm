import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static int n, m, max;
    private static ArrayList<Point> houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            max = 0;
            houses = new ArrayList<>();
            int profit = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        profit += m;
                        houses.add(new Point(i, j));
                    }
                }
            }

            int startK = getStartK(profit);

            for (int k = startK; k >= 1; k--) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        max = Math.max(max, search(i, j, k));
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static int getStartK(int profit) {
        int k = 1;

        while (profit >= k * k + (k - 1) * (k - 1)) {
            k++;
        }
        return k - 1;
    }

    private static int search(int x, int y, int k) {
        int cnt = 0;

        for (Point p : houses) {
            if (getDist(x, y, p.x, p.y) <= k - 1) {
                cnt++;
            }
        }

        if (cnt * m < k * k + (k - 1) * (k - 1)) return 0;
        return cnt;
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}