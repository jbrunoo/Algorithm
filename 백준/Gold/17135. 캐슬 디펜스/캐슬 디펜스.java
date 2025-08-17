import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    private static int n, m, d, max;
    private static int[][] castle;
    private static int[][] castleCopy;
    private static boolean[] archer;
    private static boolean[][] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        castle = new int[n][m];
        castleCopy = new int[n][m];
        archer = new boolean[m];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                castle[i][j] = num;
                castleCopy[i][j] = num;
            }
        }

        combination(0, 0);

        System.out.println(max);
    }

    private static void combination(int start, int depth) {
        if (depth == 3) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    castleCopy[i][j] = castle[i][j];
                }
            }

            int cnt = attack();
            if (max < cnt) max = cnt;

            return;
        }

        for (int i = start; i < m; i++) {
            archer[i] = true;
            combination(i + 1, depth + 1);
            archer[i] = false;
        }
    }

    // 궁수 3명 뽑고
    // 돌리는데 적 탐색해서
    // 적 타켓이 되는 적 다 선택해본 다음
    // 그 중에서 제일 맞는 놈을 visited 하나 선택하자
    // 이걸 3회 반복
    // 그리고 visited에 있는거 제거

    private static int attack() {
        int cnt = 0;
        for (int row = n - 1; row >= 0; row--) {
            target = new boolean[n][m];

            for (int i = 0; i < m; i++) {
                if (archer[i]) {
                    Point p = selectTarget(row + 1, i);
                    if (p.x != -1) {
                        target[p.x][p.y] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (target[i][j]) {
                        castleCopy[i][j] = 0;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private static Point selectTarget(int row, int y1) {
        int minDistance = d + 1;
        Point p = new Point(-1, -1);

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (castleCopy[i][j] == 1) {
                    int dist = getDistance(row, y1, i, j);
                    if (dist <= d) {
                        if (minDistance > dist || minDistance == dist && j < p.y) {
                            minDistance = dist;
                            p.x = i;
                            p.y = j;
                        }
                    }
                }
            }
        }

        return p;
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}